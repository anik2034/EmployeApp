package com.example.getemployee;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListPage extends AppCompatActivity {
    private RecyclerView rv;
    private RecyclerView.LayoutManager lm;
    private ImageRecyclerAdapter ra;
    private Employee e1 = new Employee(R.drawable.pic1,
            "Timothee Chalamet", "Actively Looking",
            "100", "90", "60");
    private Employee e2 = new Employee(R.drawable.pic2,
            "Scarlett Johansson", "Actively Looking",
            "100", "90", "60");
    private Employee e3 = new Employee(R.drawable.pic3,
            "Ben Barnes", "Actively Looking",
            "100", "90", "60");
    private Employee e4 = new Employee(R.drawable.pic4,
            "The Weeknd", "Actively Looking",
            "100", "90", "60");
    private Employee e5 = new Employee(R.drawable.pic5,
            "Lana Del Ray", "Actively Looking",
            "100", "90", "60");
    private Employee e6 = new Employee(R.drawable.pic6,
            "Emma Watson", "Actively Looking",
            "100", "90", "60");
    private Employee e7 = new Employee(R.drawable.pic7,
            "Harry Styles", "Actively Looking",
            "100", "90", "60");
    private Employee e8 = new Employee(R.drawable.pic8,
            "Robert Pattinson", "Actively Looking",
            "100", "90", "60");


    private ArrayList<Employee> list;

    private SearchView searchView;
    private ArrayList<Employee> filtered;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employees_list_layout);

        list = new ArrayList<>();
        searchView = findViewById(R.id.search);


        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);
        list.add(e6);
        list.add(e7);
        list.add(e8);


        rv = findViewById(R.id.rv);
        lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(lm);
        ra = new ImageRecyclerAdapter(list, this);
        rv.setAdapter(ra);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filter(s);
                return false;
            }
        });


    }

    public void filter(String s) {
        filtered = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).getName().toLowerCase().contains(s.toLowerCase()))) {
                filtered.add(list.get(i));

            }
        }
        if (filtered.isEmpty()) {
            filtered.add(new Employee(R.drawable.noresults, "No Results", "", "", "", ""));
        }
        Log.i("Filtered", filtered.size() + "");
        ra.filterList(filtered);


    }


}
