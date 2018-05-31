package com.example.asus.aplikasifoundit;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.UUID;

public class HalamanHasilCariBarang extends AppCompatActivity {

    ListView CariBarang;
    DatabaseReference ref;
    FirebaseDatabase database;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    LaporanBarangTinggal laporanBarangTinggal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_hasil_cari_barang);

        CariBarang = (ListView)findViewById(R.id.lvCariBarang);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("laporan");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.hasil_cari, R.id.tvNamaCafe, list);
        laporanBarangTinggal = new LaporanBarangTinggal();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren())
                {
                    laporanBarangTinggal = ds.getValue(LaporanBarangTinggal.class);
                    list.add(laporanBarangTinggal.getNamaCafe().toString() + "  " +laporanBarangTinggal.getNomorUntukDihubungi().toString()+ "  "+laporanBarangTinggal.getTanggalDitemukan().toString()+ "  ");
                }
                CariBarang.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
