package com.one.utsulang;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.one.utsulang.model.Elektronik;

import java.util.List;


public class GaleryActivity extends AppCompatActivity {

    List<Elektronik> elektroniks;
    int indeksTampil = 0;
    String jenisElektronik;
    Button btnPertama,btnTerakhir,btnSebelumnya,btnBerikutnya;
    TextView txJenis,txHarga,txDeskripsi,txJudul;
    ImageView ivFotoElektronik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_ras);
        Intent intent = getIntent();
        jenisElektronik = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        elektroniks = DataProvider.getElektroniksByTipe(this,jenisElektronik);
        inisialisasiView();
        tampilkanProfil();
    }

    private void inisialisasiView() {
        btnPertama = findViewById(R.id.btnPertama);
        btnSebelumnya = findViewById(R.id.btnSebelumnya);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);
        btnTerakhir = findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> elektronikPertama());
        btnTerakhir.setOnClickListener(view -> elektronikTerakhir());
        btnSebelumnya.setOnClickListener(view -> elektronikSebelumnya());
        btnBerikutnya.setOnClickListener(view -> elektronikBerikutnya());

        txJenis = findViewById(R.id.txJenis);
        txHarga = findViewById(R.id.txHarga);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoElektronik = findViewById(R.id.GambarElektronik);

        txJudul = findViewById(R.id.txJudul);
        txJudul.setText("Berbagai Macam Jenis "+jenisElektronik);
    }


    private void tampilkanProfil() {
        Elektronik k = elektroniks.get(indeksTampil);
        Log.d("Tv","Menampilkan Tv "+k.getJenis());
        txJenis.setText(k.getJenis());
        txHarga.setText(k.getAsal());
        txDeskripsi.setText(k.getDeskripsi());
        ivFotoElektronik.setImageDrawable(this.getDrawable(k.getDrawableRes()));
    }

    private void elektronikPertama() {
        int posAwal = 0;
        if (indeksTampil == posAwal) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAwal;
            tampilkanProfil();
        }
    }

    private void elektronikTerakhir() {
        int posAkhir = elektroniks.size() - 1;
        if (indeksTampil == posAkhir) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAkhir;
            tampilkanProfil();
        }
    }

    private void elektronikBerikutnya() {
        if (indeksTampil == elektroniks.size() - 1) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil++;
            tampilkanProfil();
        }
    }

    private void elektronikSebelumnya() {
        if (indeksTampil == 0) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil--;
            tampilkanProfil();
        }
    }
}