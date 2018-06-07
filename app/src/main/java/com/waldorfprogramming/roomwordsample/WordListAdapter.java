package com.waldorfprogramming.roomwordsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Zeero on 6/6/2018 at 8:11 PM.
 */
public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView mWordItemView;

        private WordViewHolder(View itemView) {
            super(itemView);
            mWordItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Word> mWords; //cached copy of words

    WordListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if(mWords != null) {
            Word current = mWords.get(position);
            holder.mWordItemView.setText(current.getWord());
        }else{
            // covers the case of data not being ready yet.
            holder.mWordItemView.setText("No Word");
        }
    }

    void setWords(List<Word> words) {
        mWords = words;
        notifyDataSetChanged();
    }

    // getItemCount is called many times, and when it is first called,
    // mWords has not been updated(maens initially, its null, and we cant return null

    @Override
    public int getItemCount() {
        if(mWords != null)
        return mWords.size();
        else return 0;
    }
}
