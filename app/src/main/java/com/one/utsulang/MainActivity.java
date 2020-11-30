package com.one.utsulang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnTv,btnKamera;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnTv = findViewById(R.id.btn_buka_Tv);
        btnKamera = findViewById(R.id.btn_buka_Kamera);
        btnTv.setOnClickListener(view -> bukaGaleri("Tv"));
        btnKamera.setOnClickListener(view -> bukaGaleri("Kamera"));
    }

    private void bukaGaleri(String jenisElektronik) {
        Log.d("MAIN","Buka activity kucing");
        Intent intent = new Intent(this, GaleryActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisElektronik);
        startActivity(intent);
    }

}