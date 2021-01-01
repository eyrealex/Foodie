package com.alexeyre.foodie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ChineseActivity extends AppCompatActivity {

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese);
        setSupportActionBar(toolbar);
        toolbar = findViewById(R.id.toolbar);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChineseActivity.this, HomeActivity.class));
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ChineseActivity.this, HomeActivity.class));
        finish();
    }


}