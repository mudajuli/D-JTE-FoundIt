package com.example.asus.aplikasifoundit;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListLaporan extends ArrayAdapter<LaporanBarangTinggal>{

    private Activity context;
    private List<LaporanBarangTinggal> listLaporanBarangTinggal;

    public ListLaporan(Activity context, List<LaporanBarangTinggal> listLaporanBarangTinggal){

        super(context, R.layout.hasil_cari, listLaporanBarangTinggal);
        this.context = context;
        this.listLaporanBarangTinggal = listLaporanBarangTinggal;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.hasil_cari, null, true);

        TextView textViewNamaCafe = (TextView) listViewItem.findViewById(R.id.tvNamaCafe);
        TextView textViewTanggal = (TextView) listViewItem.findViewById(R.id.tvTanggal);
        TextView textViewNomorhp = (TextView)listViewItem.findViewById(R.id.tvNomor);

        LaporanBarangTinggal laporanBarangTinggal = listLaporanBarangTinggal.get(position);

        textViewNamaCafe.setText(laporanBarangTinggal.getNamaCafe());
        textViewTanggal.setText(laporanBarangTinggal.getTanggalDitemukan());
        textViewNomorhp.setText(laporanBarangTinggal.getNomorUntukDihubungi());

        return listViewItem;
    }
}
