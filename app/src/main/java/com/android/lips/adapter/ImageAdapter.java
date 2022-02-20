package com.android.lips.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.android.lips.R;
import com.android.lips.databinding.AllNoticeItemBinding;
import com.android.model.ImageModel;
import com.android.model.NoticeModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.viewHolder> {
    ArrayList<ImageModel> imageModels;
    Context context;
    LayoutInflater inflater;

    public ImageAdapter(ArrayList<ImageModel> imageModels, Context context) {
        this.imageModels = imageModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        return new ImageAdapter.viewHolder(DataBindingUtil.inflate(inflater, R.layout.all_notice_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.viewHolder holder, int position) {
        ImageModel ImageModel = imageModels.get(position);
        holder.binding.noticeTitle.setText(ImageModel.getImageTitle());
        if(ImageModel.getDate() !=null){
            holder.binding.noticeDate.setText(ImageModel.getDate());
        }
        Glide.with(context).load(ImageModel.getImage()).into(holder.binding.noticeImage);
    }

    @Override
    public int getItemCount() {
        return imageModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        AllNoticeItemBinding binding;

        public viewHolder(AllNoticeItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
