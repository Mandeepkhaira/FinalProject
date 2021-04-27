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
        holder.nametxt.setText(String.valueOf(name.get(position)));
        holder.emailtxt.setText(String.valueOf(email.get(position)));
        holder.phonetxt.setText(String.valueOf(phn.get(position)));
        holder.dobtxt.setText(String.valueOf(dob.get(position)));
        holder.qualificationtxt.setText(String.valueOf(qualification.get(position)));

    }

    @Override
    public int getItemCount()
    {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nametxt,emailtxt,phonetxt,dobtxt,qualificationtxt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nametxt=itemView.findViewById(R.id.name);
            emailtxt=itemView.findViewById(R.id.E);
            phonetxt=itemView.findViewById(R.id.P);
            dobtxt=itemView.findViewById(R.id.dob);
            qualificationtxt=itemView.findViewById(R.id.Q);
        }
    }
}
