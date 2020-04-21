package com.rohit.mvvm_with_recyclerview;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rohit.mvvm_with_recyclerview.Models.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    ModelViewModel viewModel;
    RecyclerView recyclerView;
    Adapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_main);
        viewModel = ViewModelProviders.of(MainActivity.this).get(ModelViewModel.class);
        viewModel.getUserMutableLiveData().observe(MainActivity.this, userListUpdateObserver);

    }


    Observer<ArrayList<User>> userListUpdateObserver = new Observer<ArrayList<User>>() {
        @Override
        public void onChanged(ArrayList<User> userArrayList) {
            recyclerViewAdapter = new Adapter(MainActivity.this,userArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            recyclerView.setAdapter(recyclerViewAdapter);
        }
    };


}