package com.ax.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class AddToListActivity extends AppCompatActivity {
    Spinner sGender;
    Spinner sStatus;
    EditText tvName;
    EditText tvDescription;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_list);
        sGender = findViewById(R.id.add_to_list_activity_sGender);
        sStatus = findViewById(R.id.add_to_list_activity_sStatus);
        tvName = findViewById(R.id.add_to_list_activity_tvName);
        tvDescription = findViewById(R.id.add_to_list_activity_tvDescription);
        btnAdd = findViewById(R.id.add_to_list_activity_btnAdd);
        SimpleImageArrayAdapter genderArrayAdapter = new SimpleImageArrayAdapter(this, new Integer[]{R.drawable.maleicon, R.drawable.femaleicon});
        sGender.setAdapter(genderArrayAdapter);
        SimpleImageArrayAdapter statusArrayAdapter = new SimpleImageArrayAdapter(this, new Integer[]{R.drawable.tick, R.drawable.cross});
        sStatus.setAdapter(statusArrayAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lists.names.add(tvName.getText().toString());
                Lists.infos.add(tvDescription.getText().toString());
                Lists.genders.add((Integer) sGender.getSelectedItem());
                Lists.ticks.add((Integer) sStatus.getSelectedItem());
                Intent i = new Intent(AddToListActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    public class SimpleImageArrayAdapter extends ArrayAdapter<Integer> {
        private Integer[] images;

        public SimpleImageArrayAdapter(Context context, Integer[] images) {
            super(context, android.R.layout.simple_spinner_item, images);
            this.images = images;
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            return getImageForPosition(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getImageForPosition(position);
        }

        private View getImageForPosition(int position) {
            ImageView imageView = new ImageView(getContext());
            imageView.setBackgroundResource(images[position]);
            imageView.setLayoutParams(new AbsListView.LayoutParams(150, 128));
            return imageView;
        }
    }
}