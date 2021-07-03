package com.example.gridview;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItem;

import com.example.gridview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Grid view");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] flowerName = {"Shiva","Shiva","Shiva","Shiva",
        "Shiva","Shiva","Shiva","Shiva","Shiva","Shiva"};
        int[] flowerImages = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,
                R.drawable.h,R.drawable.i,R.drawable.j};

        GridAdapter gridAdapter = new GridAdapter(MainActivity.this,flowerName,flowerImages);
        binding.gridView.setAdapter(gridAdapter);


        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this,"You Clicked on "+ flowerName[position],Toast.LENGTH_SHORT).show();

            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}