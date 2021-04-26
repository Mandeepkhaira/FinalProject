package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customAdapter extends RecyclerView.Adapter<customAdapter.MyViewHolder> {
    Context context;
    ArrayList name,email,phn,dob,qualification;

    customAdapter(Context context,ArrayList name,ArrayList email,ArrayList phn,ArrayList dob,ArrayList qualification)
    {
        this.context=context;
        this.name=name;
        this.email=email;
        this.phn=phn;
        this.dob=dob;
        this.qualification=qualification;
    }
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator=LayoutInflater.from(context);
        View view=inflator.inflate (R.layout.activity4,parent,false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(String.valueOf(name.get(position)));
        holder.email.setText(String.valueOf(email.get(position)));
        holder.phone.setText(String.valueOf(phn.get(position)));
        holder.dob.setText(String.valueOf(dob.get(position)));
        holder.qualification.setText(String.valueOf(qualification.get(position)));

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,email,phone,dob,qualification;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            email=itemView.findViewById(R.id.email);
            phone=itemView.findViewById(R.id.phone);
            dob=itemView.findViewById(R.id.dob);
            qualification=itemView.findViewById(R.id.qualification);
        }
    }
}
