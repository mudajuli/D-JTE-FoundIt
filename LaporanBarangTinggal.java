package com.example.asus.aplikasifoundit;

public class LaporanBarangTinggal {
    public String namaCafe;
    public String nomorUntukDihubungi;
    public String tanggalDitemukan;
    public String idLaporan;

    public LaporanBarangTinggal(){

    }

    public LaporanBarangTinggal(String namaCafe, String nomorUntukDihubungi, String tanggalDitemukan, String idLaporan) {
        this.namaCafe = namaCafe;
        this.nomorUntukDihubungi = nomorUntukDihubungi;
        this.tanggalDitemukan = tanggalDitemukan;
        this.idLaporan = idLaporan;

    }

    public String getNamaCafe() {
        return namaCafe;
    }

    public String getNomorUntukDihubungi() {
        return nomorUntukDihubungi;
    }

    public String getTanggalDitemukan() {
        return tanggalDitemukan;
    }

    public String getIdLaporan() {
        return idLaporan;
    }
}

