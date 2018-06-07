package com.waldorfprogramming.roomwordsample;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Zeeroh on 6/6/2018 at 7:02 AM.
 */

// Protip: if the SQL table has the word(or primary key) already in the database,
    // SQLs default behavior is to ABORT so you do not over write keys.

    // you can use a conflict strategy:
    // if the table has more than one column, you can use
    // @Insert(onConflict = OnConflictStrategy.REPLACE)
    // to replace the row

// If you use LiveData independently from Room, you have to manage updating the data.
//    LiveData has no publicly available methods to update the stored data.
//
//    If you, the developer, want to update the stored data,
//    you must use MutableLiveData instead of LiveData.
//    The MutableLiveData class has two public methods
//    that allow you to set the value of a LiveData object,
//    setValue(T) and postValue(T). Usually, MutableLiveData is used in the ViewModel,
//    and then the ViewModel only exposes immutable LiveData objects to the observers

@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords(); // wrapped the List<Word> with LiveData<>
}

