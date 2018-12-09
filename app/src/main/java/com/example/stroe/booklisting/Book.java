package com.example.stroe.booklisting;

/**
 * {@link Book} contains specific information regarding a book
 * such as title, authors, publisher, description
 * and a url which relocates the user to a page with more book info
 */
public class Book {
    /** Book title */
    private String mTitle;
    /** Author of the book*/
    private String mAuthor;
    /** Book rating*/
    private double mRating;
    /** Short description*/
    private String mDescription;
    /** URL for more information regarding the book*/
    private String mBookURL;

    /**
     * Create a Book Object where:
     * @param title is the book's title
     * @param author is the book's author
     * @param rating is the average rating given by reviewers of this book
     * @param description is the book's description
     * @param url is an URL with more info regarding the book
     * */
    public Book(String title, String author, double rating, String description, String url){
        mTitle = title;
        mAuthor = author;
        mRating = rating;
        mDescription = description;
        mBookURL = url;
    }

    public String getTitle(){
        return mTitle;
    }

    public String getAuthor(){
        return mAuthor;
    }

    public double getRating(){
        return mRating;
    }

    public String getDescription(){
        return mDescription;
    }

    public String getURL(){
        return mBookURL;
    }
}
