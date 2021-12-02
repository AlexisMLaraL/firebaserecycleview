package com.misaelal.firebaserecycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    @Override
    public MyItemRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyItemRecyclerViewAdapter.ViewHolder holder, int position) {

    }

    public int getItemCount() {
        return 0;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mItemNumber;
        TextView mContent;
        Button mButton2;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mItemNumber = itemView.findViewById(R.id.item_number);
            this.mContent = itemView.findViewById(R.id.content);
            this.mButton2 = itemView.findViewById(R.id.button2);
        }
    }
}