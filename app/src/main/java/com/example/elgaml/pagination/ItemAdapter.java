package com.example.elgaml.pagination;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ItemAdapter extends PagedListAdapter<Item,ItemAdapter.ItemViewHolder> {

     private Context ctx;

    protected ItemAdapter(Context context) {
        super(DCallback);
        this.ctx=context;
    }

    @NonNull
    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(ctx).inflate(R.layout.item_recycler,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder holder, int position) {

        Item item = getItem(position);

        if (item != null) {

            Glide.with(ctx)
                    .load(item.owner.profile_image)
                    .into(holder.imageView);

            holder.textView.setText(item.owner.display_name);

        } else {
            Toast.makeText(ctx, "Item is null", Toast.LENGTH_LONG).show();
        }
    }

    private static  DiffUtil.ItemCallback DCallback = new DiffUtil.ItemCallback<Item>() {
        @Override
        public boolean areItemsTheSame( Item oldItem,  Item newItem) {
            return oldItem.answer_id==newItem.answer_id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
            return oldItem.equals(newItem);
        }
    };

    class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textViewName);
        }
    }

}
