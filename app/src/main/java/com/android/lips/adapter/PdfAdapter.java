package com.android.lips.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.lips.PdfViewActivity;
import com.android.lips.R;
import com.android.lips.databinding.AllPdfListItemBinding;
import com.android.model.EBookModel;

import java.util.ArrayList;

public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.viewHolder> {
    ArrayList<EBookModel> eBookModelArrayList;
    LayoutInflater inflater;
    Context context;

    public PdfAdapter(ArrayList<EBookModel> eBookModelArrayList, Context context) {
        this.eBookModelArrayList = eBookModelArrayList;

        this.context = context;
    }

    @NonNull
    @Override
    public PdfAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        return new viewHolder(DataBindingUtil.inflate(inflater, R.layout.all_pdf_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PdfAdapter.viewHolder holder, int position) {
        EBookModel eBookModel = eBookModelArrayList.get(position);
        holder.binding.itemCount.setText(String.valueOf(position+1));
        holder.binding.pdfName.setText(eBookModel.geteBookTitle()+".pdf");
        holder.binding.layout.setOnClickListener(v->{
            Intent intent=new Intent(context, PdfViewActivity.class);
            intent.putExtra("pdfUrl",eBookModel.geteBookPdf());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return eBookModelArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        AllPdfListItemBinding binding;

        public viewHolder(AllPdfListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}