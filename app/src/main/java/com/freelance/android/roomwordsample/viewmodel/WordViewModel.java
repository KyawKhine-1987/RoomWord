package com.freelance.android.roomwordsample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.freelance.android.roomwordsample.data.Word;
import com.freelance.android.roomwordsample.data.WordRepository;

import java.util.List;

/**
 * Created by KyawKhine on 12/18/2018 2:45 PM.
 */


public class WordViewModel extends AndroidViewModel {

    private static final String LOG_TAG = WordViewModel.class.getName();
    private WordRepository mRepository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(Application application) {
        super(application);
        this.mRepository = new WordRepository(application);
        this.mAllWords = mRepository.getAllWords();
        Log.i(LOG_TAG, "TEST: WordViewModel() is called...");
    }

    public LiveData<List<Word>> getmAllWords() {
        Log.i(LOG_TAG, "TEST: getmAllWords() is called...");
        return mAllWords;
    }

    public void insert(Word word) {
        Log.i(LOG_TAG, "TEST: insert() is called...");
        mRepository.insert(word);
    }
}
