package com.example.tugas_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detail_Item extends AppCompatActivity {

    private TextView tvName, tvHarga, tvDescription;
    private ImageView photo;
    String name,harga,description;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_item);

        tvName = findViewById(R.id.tvName);

        tvHarga = findViewById(R.id.tvHarga);
        tvDescription = findViewById(R.id.tvDescription);

        photo = findViewById(R.id.photo);

        name = getIntent().getStringExtra("name");
        harga = getIntent().getStringExtra("harga");
        description = getIntent().getStringExtra("detail");


        image = getIntent().getIntExtra("photo", 0);
        photo.setImageResource(image);
        tvName.setText(name);
        tvHarga.setText(harga);
        tvDescription.setText(description);

    }

    public void btnBack(View view) {
        Intent intent = new Intent(Detail_Item.this, MainActivity.class);
        startActivity(intent);
    }
}
