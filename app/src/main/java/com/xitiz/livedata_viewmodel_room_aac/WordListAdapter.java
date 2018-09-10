package com.xitiz.livedata_viewmodel_room_aac;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.MyViewHolder> {
    private List<Word> wordList;
    private LayoutInflater layoutInflater;

    public WordListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    void setWordList(List<Word> wordList) {
        this.wordList = wordList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WordListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.MyViewHolder holder, int position) {
        if (wordList != null) {
            Word word = wordList.get(position);
            holder.wordItemView.setText(word.getWord());
        } else {
            //covers the data not being ready yet.
            holder.wordItemView.setText("No Words");
        }

    }
    /* getItemCount is called many times so at first updated initially  and we cant return null makes more robust*/

    @Override
    public int getItemCount() {
        if (wordList != null) {
            return wordList.size();

        } else return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView wordItemView;

        MyViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }
}
