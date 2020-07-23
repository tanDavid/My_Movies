package sg.edu.rp.c346.id19002765.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovies;
    ArrayList<Movie> alMovie;
    CustomAdapter caMovie;
    ImageView rating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovies = findViewById(R.id.listViewMovieList);
        rating = findViewById(R.id.imageViewRating);
        alMovie = new ArrayList<>();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2014, 11, 15);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2015, 5, 15);

        alMovie.add(new Movie("The Avengers", 2012, "pg13", "Action | Sci-Fi", calendar1.getInstance(), "Golden Village - Bishan",
                "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army."  ));

        alMovie.add(new Movie("Planes", 2013, "pg","Animation | Comedy", calendar2.getInstance(),
                "calendar2", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race."));

        caMovie = new CustomAdapter(this,R.layout.row, alMovie);
        lvMovies.setAdapter(caMovie);


        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Prep intent
                Intent intentDetail = new Intent(MainActivity.this,MovieDetailsActivity.class);
                //Insert data
                Movie currentMovie = alMovie.get(position);
                intentDetail.putExtra("title", currentMovie.getTitle());
                intentDetail.putExtra("year", currentMovie.getYear());
                intentDetail.putExtra("rated", currentMovie.getRated());
                intentDetail.putExtra("genre", currentMovie.getGenre());
                intentDetail.putExtra("watchDate", currentMovie.getWatched_on());
                intentDetail.putExtra("theatre", currentMovie.getIn_theatre());
                intentDetail.putExtra("desc", currentMovie.getDescription());

                startActivity(intentDetail);
            }
        });


    }

}
