package com.example.leotrieu.cinemaninja;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Movie> movieArrayList;
    MovieAdapter adapter;

    Movie[] movies = new Movie[]{
            new Movie(
                    "Zootopia",
                    "The modern mammal metropolis of Zootopia is a city like no other. Comprised of habitat neighborhoods like ritzy Sahara Square and frigid Tundratown, it’s a melting pot where animals from every environment live together—a place where no matter what you are, from the biggest elephant to the smallest shrew, you can be anything.",
                    "Byron Howard",
                    974,
                    "http://trailers.apple.com/trailers/disney/zootopia/images/poster.jpg",
                    "http://movietrailers.apple.com/movies/disney/zootopia/zootopia-tlr2_i320.m4v"
            ),

            new Movie(
                    "Passengers",
                    "Jennifer Lawrence and Chris Pratt star in an exciting action-thriller about two passengers who are on a 120-year journey to another planet when their hibernation pods wake them 90 years too early.",
                    "Morten Tyldum",
                    825,
                    "http://trailers.apple.com/trailers/sony_pictures/passengers/images/poster.jpg",
                    "http://movietrailers.apple.com/movies/sony_pictures/passengers/passengers-clip-i-woke-up-too-soon_i320.m4v"
            ),
            new Movie(
                    "Transformers: The Last Knight",
                    "Humans and Transformers are at war, Optimus Prime is gone. The key to saving our future lies buried in the secrets of the past, in the hidden history of Transformers on Earth.",
                    "Michael Bay",
                    891,
                    "http://trailers.apple.com/trailers/paramount/transformers-the-last-knight/images/poster.jpg",
                    "http://movietrailers.apple.com/movies/paramount/transformers-the-last-knight/transformers-5-big-game-spot-2_i320.m4v"
            ),
            new Movie(
                    "Megan Leavey",
                    "MEGAN LEAVEY is based on the true life story of a young marine corporal (Kate Mara) whose unique discipline and bond with her military combat dog saved many lives during their deployment in Iraq.",
                    "Gabriela Cowperthwaite",
                    612,
                    "http://trailers.apple.com/trailers/independent/megan-leavey/images/poster.jpg",
                    "http://movietrailers.apple.com/movies/independent/megan-leavey/megan-leavey-trailer-1_i320.m4v"
            ),
            new Movie(
                    "Logan",
                    "In the near future, a weary Logan cares for an ailing Professor X somewhere on the Mexican border. However, Logan's attempts to hide from the world and his legacy are upended when a young mutant arrives, pursued by dark forces.",
                    "James Mangold",
                    783,
                    "http://trailers.apple.com/trailers/fox/logan/images/poster.jpg",
                    "http://movietrailers.apple.com/movies/fox/logan/logan-clip-you-know-the-drill_i320.m4v"
            ),
            new Movie(
                    "Beauty and the Beast",
                    "Disney’s “Beauty and the Beast” is a live-action re-telling of the studio’s animated classic which refashions the classic characters from the tale as old as time for a contemporary audience, staying true to the original music while updating the score with several new songs.",
                    "Bill Condon",
                    579,
                    "http://trailers.apple.com/trailers/disney/beautyandthebeast/images/poster.jpg",
                    "http://movietrailers.apple.com/movies/disney/beautyandthebeast2016/beauty-and-the-beast-clip-gaston_i320.m4v"
            ),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setIcon(R.drawable.ic_action_logo);
            actionBar.setTitle("      " + actionBar.getTitle());
        }



        movieArrayList = new ArrayList<>(Arrays.asList(movies));
        adapter = new MovieAdapter(this, movieArrayList);

        ListView movieListView = (ListView) findViewById(R.id.movieListView);
        movieListView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("SEARCH", newText);

                movieArrayList.clear();

                if (newText.equals("")) {
                    movieArrayList.addAll(Arrays.asList(movies));
                } else {
                    for (Movie movie : movies) {
                        if (movie.getName().toLowerCase().contains(newText.toLowerCase())) {
                            movieArrayList.add(movie);
                        }
                    }
                }

                adapter.notifyDataSetChanged();

                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}
