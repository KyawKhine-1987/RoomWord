package com.freelance.android.roomwordsample.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by KyawKhine on 12/17/2018 10:01 PM.
 */

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    public String mWord; /*should be declared public datatype.
                           @PrimaryKey(autoGenerate = true) => integer datatype can do autogenerate.*/

    public Word(@NonNull String mWord) {
        this.mWord = mWord;
    }

    public String getmWord() {
        return mWord;
    }
}
