package com.andriod.course.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andriod.course.R;
import com.andriod.course.modules.Student;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    ArrayList<Student> names;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, age;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text);
            age = itemView.findViewById(R.id.age);
        }
    }

    public StudentAdapter(ArrayList<Student> names) {
        this.names = names;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Student student = names.get(position);
        holder.name.setText(student.getName());
        holder.age.setText(student.getAge());
    }

    @Override
    public int getItemCount() {
        return names.size();
    }


}
