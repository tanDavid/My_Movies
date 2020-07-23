package sg.edu.rp.c346.id19002765.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;


    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects){
        super(context,resource,objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        ImageView ivMovie = rowView.findViewById(R.id.imageViewRating);
        TextView movieName = rowView.findViewById(R.id.textViewName);
        TextView genre = rowView.findViewById(R.id.textViewGenre);
        TextView year = rowView.findViewById(R.id.textViewYear);

        // Obtain the Android Version information based on the position
        Movie currentItem = movieList.get(position);

        // Set values to the TextView to display the corresponding information

        year.setText(""+ currentItem.getYear() + "-");
        genre.setText("" + currentItem.getGenre());


        if(currentItem.getYear() != 2020){
            movieName.setText(""+currentItem.getTitle());
        }
        else{
            movieName.setText(""+currentItem.getTitle());
        }


        if(currentItem.getRated()== "g"){
            ivMovie.setImageResource(R.drawable.rating_g);

        }
        else if(currentItem.getRated()=="pg"){
            ivMovie.setImageResource(R.drawable.rating_pg);

        }
        else if(currentItem.getRated()=="pg13"){
            ivMovie.setImageResource(R.drawable.rating_pg13);

        }
        else if(currentItem.getRated()=="nc16"){
            ivMovie.setImageResource(R.drawable.rating_nc16);

        }
        else if(currentItem.getRated()=="m18"){
            ivMovie.setImageResource(R.drawable.rating_m18);

        }
        else{
            ivMovie.setImageResource(R.drawable.rating_r21);

        }

        return rowView;
    }
}
