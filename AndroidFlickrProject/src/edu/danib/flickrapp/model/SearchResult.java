package edu.danib.flickrapp.model;

import java.io.Serializable;

public class SearchResult implements Serializable {

	private static final long serialVersionUID = -2227304584163394125L;

	private static final String OUTPUT_FORMAT = "Title: %s \n Author ID: %s\n";

    private String title;
    private String authorId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String fromUser) {
        this.title = fromUser;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String text) {
        this.authorId = text;
    }

    @Override
    public String toString() {
        return String.format(OUTPUT_FORMAT, getTitle(), getAuthorId());
    }
}
