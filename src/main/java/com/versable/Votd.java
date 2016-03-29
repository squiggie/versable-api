package com.versable;

import org.springframework.data.annotation.Id;

public class Votd {
    @Id
    private String _id;
    private String verseID;
    private String imageURL;
    private Long date;


    public Votd(){}

    public Votd(String verseID, String imageURL, Long date){
        this.verseID = verseID;
        this.imageURL = imageURL;
        this.date = date;
    }

    public String getVerseID() {
        return verseID;
    }

    public void setVerseID(String verseID) {
        this.verseID = verseID;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
