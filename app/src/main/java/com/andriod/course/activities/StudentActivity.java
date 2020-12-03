package com.andriod.course.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.andriod.course.R;
import com.andriod.course.modules.Student;
import com.andriod.course.adapters.StudentAdapter;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        ArrayList<Student> names = new ArrayList<>();
        names.add(new Student("Name1","age1"));
        names.add(new Student("Name2","age2"));
        names.add(new Student("Name3","age3"));
        names.add(new Student("Name4","age4"));
        names.add(new Student("Name5","age5"));
        names.add(new Student("Name6","age6"));
        names.add(new Student("Name7","age7"));

        RecyclerView recyclerview = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerview.setLayoutManager(layoutManager);
        StudentAdapter studentAdapter = new StudentAdapter(names);
        recyclerview.setAdapter(studentAdapter);
    }
}
