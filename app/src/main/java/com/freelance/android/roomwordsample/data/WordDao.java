package com.freelance.android.roomwordsample.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by KyawKhine on 12/17/2018 10:33 PM.
 */

@Dao
public interface WordDao {

    @Insert
    void insert(Word word); //@Insert(onConflict = OnConflictStrategy.REPLACE)

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();
}
