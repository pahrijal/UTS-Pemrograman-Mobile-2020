package com.one.utsulang.model;

public class Elektronik {
    private String jenis;
    private String harga;
    private String asal;
    private String deskripsi;
    private int drawableRes;

    public Elektronik(String jenis, String harga, String asal, String deskripsi, int drawableRes) {
        this.jenis = jenis;
        this.harga = harga;
        this.asal = asal;
        this.deskripsi = deskripsi;
        this.drawableRes = drawableRes;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String ras) {
        this.harga = harga;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getDrawableRes() {
        return drawableRes;
    }

    public void setDrawableRes(int drawableRes) {
        this.drawableRes = drawableRes;
    }
}
