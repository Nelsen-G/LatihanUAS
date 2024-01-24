package com.example.latihanuas6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<Student> listStudent;

    private ItemClickListener itemClickListener;
    private Context c;

    public ItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public RecyclerViewAdapter(ArrayList<Student> listStudent, Context c) {
        this.listStudent = listStudent;
        this.c = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.student_list_individual, parent, false);

        return new MyViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Student s = listStudent.get(position);

        holder.viewName.setText(s.getName());
        holder.viewNim.setText(String.valueOf(s.getNim()));
        holder.viewEmail.setText(s.getEmail());
        holder.viewHp.setText(String.valueOf(s.getHp()));

    }

    @Override
    public int getItemCount() {
        return listStudent.size();
    }
}
