package com.ax.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.ax.listapp.Lists.genders;
import static com.ax.listapp.Lists.names;
import static com.ax.listapp.Lists.ticks;
import static com.ax.listapp.Lists.infos;

public class ShowInfoActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvDescription;
    ImageView ivGender;
    ImageView ivStatus;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);
        tvName = findViewById(R.id.show_info_activity_tvName);
        tvDescription = findViewById(R.id.show_info_activity_tvDescription);
        ivGender = findViewById(R.id.show_info_activity_ivGender);
        ivStatus = findViewById(R.id.show_info_activity_ivStatus);
        btnDelete = findViewById(R.id.show_info_activity_btnDelete);
        Intent i = getIntent();
        tvName.setText(i.getStringExtra("name"));
        tvDescription.setText(i.getStringExtra("description"));
        ivGender.setImageResource(i.getIntExtra("gender", R.drawable.tick));
        ivStatus.setImageResource(i.getIntExtra("status", R.drawable.tick));
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = i.getIntExtra("position", -1);
                if(position == -1){
                    Toast.makeText(ShowInfoActivity.this, getString(R.string.show_info_activity_errorMessage), Toast.LENGTH_SHORT).show();
                }else {
                    genders.remove(position);
                    names.remove(position);
                    infos.remove(position);
                    ticks.remove(position);
                    Intent m = new Intent(ShowInfoActivity.this, MainActivity.class);
                    startActivity(m);
                }
            }
        });
    }
}