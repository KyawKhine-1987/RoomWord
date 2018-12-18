package com.freelance.android.roomwordsample.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

/**
 * Created by KyawKhine on 12/17/2018 11:39 PM.
 */


public class WordRepository {

    private static final String LOG_TAG = WordRepository.class.getName();

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        Log.i(LOG_TAG, "TEST: WordRepository() is called...");

        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        Log.i(LOG_TAG, "TEST: getAllWords() is called...");

        return mAllWords;
    }

    public void insert (Word word) {
        Log.i(LOG_TAG, "TEST: insert() is called...");

        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            Log.i(LOG_TAG, "TEST: insertAsyncTask() is called...");

            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            Log.i(LOG_TAG, "TEST: doInBackground() is called...");

            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
