package com.waldorfprogramming.roomwordsample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Zeeroh on 6/6/2018 at 6:43 AM.
 */

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey // each entity needs a Primary key (each word will be its own Primary Key)
    @NonNull // Denotes that a fiels, parameter, or method can never be null
    @ColumnInfo(name = "word") // specifies the name of the column in the table

    // every field that is stored in the database needs to be either public, or have a getter.
    // this sample provides a getter.

    // Protip: you can auto generate unique keys by annotating the primary key as follows
    // @Entity(tableNName = "word_table")
    // public class Word {

    // @PrimaryKey(autoGenerate = true)
    // private int id;

    // @NonNull
    // private String Wrod;
    // .. other fields, getters, setters
    // }
    private String mWord;

    public Word(@NonNull String word) {
        this.mWord = word;
    }

    public String getWord() {
        return this.mWord;
    }
}
