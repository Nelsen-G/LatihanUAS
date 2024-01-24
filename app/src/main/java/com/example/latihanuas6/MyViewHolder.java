package com.example.latihanuas6;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView viewName, viewNim, viewEmail, viewHp;

    public Button btnDetail;
    public MyViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);

        viewName = itemView.findViewById(R.id.viewName);
        viewNim = itemView.findViewById(R.id.viewNim);
        viewEmail = itemView.findViewById(R.id.viewEmail);
        viewHp = itemView.findViewById(R.id.viewHp);
        btnDetail = itemView.findViewById(R.id.btnDetail);

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemClickListener!= null){
                    itemClickListener.onClicked(view, getAdapterPosition());
                }
            }
        });

    }
}
