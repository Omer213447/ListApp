package com.ax.listapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ax.listapp.R;
import com.ax.listapp.adapters.RecyclerViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.ax.listapp.models.ListsModel.genders;
import static com.ax.listapp.models.ListsModel.names;
import static com.ax.listapp.models.ListsModel.ticks;
import static com.ax.listapp.models.ListsModel.infos;


public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnListListener {
    RecyclerView recyclerView;
    RecyclerView.Adapter rVAdapter;
    GridLayoutManager gridLayoutManager;
    FloatingActionButton fAbtnAdd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.main_activity_recyclerView);
        fAbtnAdd = findViewById(R.id.main_activity_fABtnAdd);
        gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        rVAdapter = new RecyclerViewAdapter(this, genders, names, ticks, this);
        recyclerView.setAdapter(rVAdapter);
        fAbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFABtnAddClick();
            }
        });
    }

    public void onFABtnAddClick(){
        Intent i = new Intent(MainActivity.this, AddToListActivity.class);
        startActivity(i);
    }

    @Override
    public void onNameClick(int position) {
        Intent i = new Intent(this, ShowInfoActivity.class);
        i.putExtra("position", position);
        i.putExtra("gender", genders.get(position));
        i.putExtra("name", names.get(position));
        i.putExtra("description", infos.get(position));
        i.putExtra("status", ticks.get(position));
        startActivity(i);
    }

    @Override
    public void onStatusClick(int position) {
        if(ticks.get(position) == R.drawable.tick){
            ticks.set(position, R.drawable.cross);
        }else {
            ticks.set(position, R.drawable.tick);
        }
        rVAdapter.notifyDataSetChanged();
    }
}