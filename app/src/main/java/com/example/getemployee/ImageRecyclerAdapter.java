package com.example.getemployee;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImageRecyclerAdapter extends RecyclerView.Adapter<ImageRecyclerAdapter.ViewHolder> {


    private ArrayList<Employee> employees;
    Context context;

    public ImageRecyclerAdapter(ArrayList<Employee> employees, ListPage activity) {

        this.employees = employees;
        this.context = activity;
    }

    @NonNull

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.small_info, parent, false);

        ViewHolder imageViewHolder = new ViewHolder(view);
        return imageViewHolder;

    }

    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Employee employee = employees.get(position);
        holder.text.setText(employee.getName());
        holder.image.setImageResource(employee.getPic());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainInfoPage.class);
                intent.putExtra("Employee", employees.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView text;
        OnImageListener listener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.text = itemView.findViewById(R.id.text);
            this.image = itemView.findViewById(R.id.image);
            this.listener = listener;
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {


            listener.onImageListener(getAdapterPosition());

        }
    }

    public interface OnImageListener {
        void onImageListener(int position);
    }

    public void filterList(ArrayList<Employee> filtered) {
        employees = filtered;
        notifyDataSetChanged();
    }
}
