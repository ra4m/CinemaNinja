package com.example.raam.cinemaninja;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class MovieAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Movie> movieArrayList;
    private LayoutInflater inflater;

    MovieAdapter (Activity activity, ArrayList<Movie> movieArrayList) {
        this.activity = activity;
        this.movieArrayList = movieArrayList;
    }

    @Override
    public int getCount() {
        return this.movieArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.movieArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.movie_list_item, null);
        }

        TextView name = (TextView) convertView.findViewById(R.id.nameTextView2);
        TextView description = (TextView) convertView.findViewById(R.id.descriptionTextView2);
        TextView number = (TextView) convertView.findViewById(R.id.numberTextView);
        TextView director = (TextView) convertView.findViewById(R.id.directorTextView);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageView);

        final Movie movie = (Movie) getItem(position);
        name.setText(movie.getName());
        if (movie.getDescription().length() <= 70) {
            description.setText(movie.getDescription());
        }
        else {
            description.setText(movie.getDescription().substring(0, 70) + "...");
        }
        number.setText(movie.getNumber() + " views");
        director.setText(movie.getDirector());
        Picasso.with(activity.getApplicationContext()).load(movie.getImage()).into(image);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, WatchMovieActivity.class);
                intent.putExtra("name", movie.getName());
                intent.putExtra("description", movie.getDescription());
                intent.putExtra("number", movie.getNumber());
                intent.putExtra("director", movie.getDirector());
                intent.putExtra("image", movie.getImage());
                intent.putExtra("url", movie.getUrl());

                activity.startActivity(intent);
            }
        });

        return convertView;
    }
}
