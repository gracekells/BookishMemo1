package com.example.bookishmemo1;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookishmemo1.databinding.ActivityMainBinding;
import com.example.bookishmemo1.databinding.ItemBukuBinding;

import java.util.ArrayList;
import java.util.List;

public class BukuViewAdapter extends RecyclerView.Adapter<BukuViewAdapter.ViewHolder> {
    private OnItemClickCallback onItemClickCallback;
    private List<BookisMemoItem> data = new ArrayList<>();
    private OnItemLongClickListener onItemLongClickListener;

    public void setData(List<BookisMemoItem> data){
        this.data = data;
        notifyDataSetChanged();
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }



    @NonNull
    @Override
    public BukuViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BukuViewAdapter.ViewHolder holder, int position) {
        int pos = holder.getAdapterPosition();
        BookisMemoItem item = data.get(pos);
//        Glide.with(holder.itemBukuBinding.ivFoto).load(item.);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemBukuBinding itemBukuBinding;

        public ViewHolder(@NonNull ItemBukuBinding itemView){
            super(itemView.getRoot());
            itemBukuBinding = itemView;
        }

    }
    public interface OnItemLongClickListener {
        void onItemLongClick(View v, BookisMemoItem item, int position);
    }

    public interface OnItemClickCallback {
        void onItemClicked(BookisMemoItem item);
    }
}
