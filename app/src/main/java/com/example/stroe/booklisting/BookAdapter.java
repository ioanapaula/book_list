package com.example.stroe.booklisting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<Book> {
    public BookAdapter(Activity context, ArrayList<Book> books){
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Book} object located at this position in the list
        final Book currentBook = getItem(position);

        //Find the TextView with the ID book_title
        TextView titleView = (TextView) listItemView.findViewById(R.id.book_title);
        //Display the title of the current Book in the TextView
        titleView.setText(currentBook.getTitle());

        //Find the TextView with the ID book_author
        TextView authorView = (TextView) listItemView.findViewById(R.id.book_authors);
        //Display the authors of the current Book in the TextView
        authorView.setText(currentBook.getAuthor());

        //Find the TextView wuth the ID book_rating
        TextView ratingView = (TextView) listItemView.findViewById(R.id.book_rating);
        // Format the rating to show 1 decimal place
        String rating = Double.toString(currentBook.getRating());
        // Display the rating of the current book in that TextView
        ratingView.setText(rating);

        //Find the TextView with the id book_description
        TextView descriptionView = (TextView) listItemView.findViewById(R.id.book_description);
        //Display the first MAX_CHAR_NUMBER characters from the book description in that TextView
        descriptionView.setText(currentBook.getDescription());

        // Set the proper background color on the ratings shape.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable ratingShape = (GradientDrawable) ratingView.getBackground();

        // Get the appropriate background color based on the current book rating
        int ratingColor = getRatingColor(currentBook.getRating());

        // Set the color on the magnitude circle
        ratingShape.setColor(ratingColor);

        return listItemView;
    }

    /**
     * Return the color of the shape background according to the integer part of the rating value
     */
    private int getRatingColor(double rating){

        switch ((int) (rating % 10)){
            case 0:
            case 1:
                return(ContextCompat.getColor(getContext(), R.color.rating1));
            case 2:
                return(ContextCompat.getColor(getContext(), R.color.rating2));
            case 3:
                return(ContextCompat.getColor(getContext(), R.color.rating3));
            case 4:
                return(ContextCompat.getColor(getContext(), R.color.rating4));
            case 5:
                return(ContextCompat.getColor(getContext(), R.color.rating5));
            default:
                return(ContextCompat.getColor(getContext(), R.color.rating3));
        }
    }
}
