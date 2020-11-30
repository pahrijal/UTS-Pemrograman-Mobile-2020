package com.one.utsulang;

import android.content.Context;

import com.one.utsulang.model.Elektronik;
import com.one.utsulang.model.Tv;

import java.util.ArrayList;
import java.util.List;

import com.one.utsulang.model.Kamera;
import com.one.utsulang.model.Tv;


public class DataProvider {
    private static List<Elektronik> elektroniks = new ArrayList<>();

    private static List<Tv> initDatatv(Context ctx) {
        List<Tv> tvs = new ArrayList<>();
        tvs.add(new Tv("Tv Antik", "1.400.000",
                "layar menggunakan layar cekung, menyesuaikan dengan tabung, dengan ukuran 18 inch", R.drawable.tv_1));
        tvs.add(new Tv("Tv Eko", "2.500.000",
                "Tv ini merupakan model terbaru di era 2018, tv ini mempunyai ragam jenis warna, dan ukuran, TV Eko ini mempunyai ukuran 20 ich", R.drawable.tv_2));
        tvs.add(new Tv("Tv LG", "2.800.000",
                "Tv ini di merupakan hasil yang tetap dikembangkan menyesuikan dengan era global, merek LG tidak asing lagi bagi semua orang, dan Tv ini mempunyai 25 ich", R.drawable.tv_3));
        tvs.add(new Tv("Tv Tabung", "1.500.000",
                "Tv ini merupakan Tv genrasi lama, yang bentuknya tidak slim, dan membutuhkan tenmpat yang cukup banyak dengan ukuran 12x20 inch", R.drawable.tv_4));
        return tvs;
    }

    private static List<Kamera> initDataKamera(Context ctx) {
        List<Kamera> kameras = new ArrayList<>();
        kameras.add(new Kamera("Kamera Cannon 10k", "5.500.000",
                "Kamera ini mempunyai resolusi yang sangat baik, serta cocok di gunakan untuk para fotografer, ukuran kamera ini adalah ukuran yang stndart 10x25 ich ", R.drawable.cam_1));
        kameras.add(new Kamera("Kamera Cannon 67x", "7.200.000 ",
                "kamera ini merupakan generasi setelah kamera cannon 10k, hasilnya sangat memuaskan, dan dengan ukuran 10x25n ich", R.drawable.cam_2));
        kameras.add(new Kamera("Kamera Cannon Mini ", "3.000.000",
                "kamera ini mempunyai frem dan hasil yang masih standar dan cocok buat foto moment keluarga, dengan ukuran 8x19 ich ", R.drawable.cam_3));
        kameras.add(new Kamera("Kamera Cannon EOS 1000", "8.700.000",
                "Kamera ini sangat cocok untuk segala kegiatan, dengan ukuran 10x27 ich", R.drawable.cam_4));
        return kameras;
    }

    private static void initAllElektroniks(Context ctx) {
        elektroniks.addAll(initDatatv(ctx));
        elektroniks.addAll(initDataKamera(ctx));
    }

    public static List<Elektronik> getAllElektronik(Context ctx) {
        if (elektroniks.size() == 0) {
            initAllElektroniks(ctx);
        }
        return  elektroniks;
    }

    public static List<Elektronik> getElektroniksByTipe(Context ctx, String jenis) {
        List<Elektronik> elektroniksByType = new ArrayList<>();
        if (elektroniks.size() == 0) {
            initAllElektroniks(ctx);
        }
        for (Elektronik h : elektroniks) {
            if (h.getJenis().equals(jenis)) {
                elektroniksByType.add(h);
            }
        }
        return elektroniksByType;
    }

}
