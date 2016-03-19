package com.versable;

import org.springframework.data.annotation.Id;

public class Verse {
    @Id
    private String _id;
    private String book;
    private int chapter;
    private int verseNum;
    private String verse;
    private String translation;
    private String tags;

    public Verse (){}

    public Verse(String book, int chapter, int verseNum, String verse, String translation, String tags){
        this.book = book;
        this.chapter = chapter;
        this.verseNum = verseNum;
        this.verse = verse;
        this.translation = translation;
        this.tags = tags;
    }
    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getVerseNum() {
        return verseNum;
    }

    public void setVerseNum(int verseNum) {
        this.verseNum = verseNum;
    }

    public String getVerse() {
        return verse;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
