package com.freelance.android.roomwordsample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.freelance.android.roomwordsample.R;
import com.freelance.android.roomwordsample.data.Word;

import java.util.List;

/**
 * Created by KyawKhine on 12/18/2018 4:03 PM.
 */


public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private static final String LOG_TAG = WordListAdapter.class.getName();
    private final LayoutInflater mInflater;
    private List<Word> mWords; // Cached copy of words

    public WordListAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(LOG_TAG, "TEST: onCreateViewHolder() is called...");

        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        Log.i(LOG_TAG, "TEST: onBindViewHolder() is called...");

        if (mWords != null) {
            Word current = mWords.get(position);
            holder.wordItemView.setText(current.getmWord());
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
        }
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        Log.i(LOG_TAG, "TEST: getItemCount() is called...");

        if (mWords != null)
            return mWords.size();
        return 0;
    }

    class WordViewHolder extends RecyclerView.ViewHolder{

        final private String LOG_TAG = WordViewHolder.class.getName();
        private final TextView wordItemView;

        public WordViewHolder(View itemView) {
            super(itemView);
            this.wordItemView = itemView.findViewById(R.id.textView);

            Log.i(LOG_TAG, "TEST: WordViewHolder() is called...");
        }
    }
}
