package com.example.bookishmemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bookishmemo1.databinding.ActivityMainBinding;

public class DetailActivity extends AppCompatActivity {
    private DetailActivity binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}