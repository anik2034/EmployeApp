package com.example.getemployee;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainInfoPage extends AppCompatActivity {
    ImageView image;
    TextView name;
    TextView status;
    TextView applied;
    TextView reviewed;
    TextView contacted;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.large_info_layout);

        image = findViewById(R.id.largeImage);
        name = findViewById(R.id.Nametext);
        status = findViewById(R.id.Status);
        applied = findViewById(R.id.appliedN);
        reviewed = findViewById(R.id.ReviewedN);
        contacted = findViewById(R.id.contactedN);
        Intent i = getIntent();

        Employee employee = (Employee) i.getSerializableExtra("Employee");
        image.setImageResource(employee.getPic());
        name.setText(employee.getName());
        applied.setText(employee.getApplied()+"");
        reviewed.setText(employee.getReviewed()+"");
        contacted.setText(employee.getContacted()+"");
        status.setText(employee.getStatus());

    }
}
