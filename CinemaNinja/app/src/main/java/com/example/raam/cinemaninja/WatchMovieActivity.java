package com.example.raam.cinemaninja;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

public class WatchMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.watch_view);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("description");
        int number = intent.getIntExtra("number", 0);
        String director = intent.getStringExtra("director");
        String image = intent.getStringExtra("image");
        String url = intent.getStringExtra("url");

        if (actionBar != null) {
            actionBar.setTitle(name);
        }

        TextView nameTextView = (TextView) findViewById(R.id.nameTextView2);
        TextView descriptionTextView = (TextView) findViewById(R.id.descriptionTextView2);
        TextView numberTextView = (TextView) findViewById(R.id.numberTextView2);
        TextView directorTextView = (TextView) findViewById(R.id.directorTextView2);
        ImageView imageView = (ImageView) findViewById(R.id.movieImage);

        nameTextView.setText(name);
        descriptionTextView.setText(description);
        numberTextView.setText(number + " views");
        directorTextView.setText(director);
        Picasso.with(this).load(image).into(imageView);

        // Play the video
        VideoView videoView = (VideoView) findViewById(R.id.videoView2);
        videoView.setVideoURI(Uri.parse(url));
        videoView.start();

        // Add controls for the video
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);

    }
}
