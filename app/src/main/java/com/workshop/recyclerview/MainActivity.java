package com.workshop.recyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView studentListView;
    private List<Student> students;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentListView = (RecyclerView)findViewById(R.id.recylerView);
        initVals();
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        gridLayoutManager = new GridLayoutManager(this,2);

        //studentListView.setLayoutManager(linearLayoutManager);
        studentListView.setLayoutManager(gridLayoutManager);
        StudentAdapter studentAdapter = new StudentAdapter(students,this);
        studentListView.setAdapter(studentAdapter);
    }

    public  void initVals(){
        students = new ArrayList<Student>();
        students.add(new Student("John",123,true));
        students.add(new Student("Bob",456,true));
        students.add(new Student("Ramesh",789,true));
        students.add(new Student("Milli",780,false));
        students.add(new Student("Julie",124,false));
        students.add(new Student("Ramesh",125,true));
        students.add(new Student("suresh",126,true));
        students.add(new Student("Jaine",127,false));
        students.add(new Student("Meera",128,false));
        students.add(new Student("Charles",129,true));
        students.add(new Student("Pankaj",130,true));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
