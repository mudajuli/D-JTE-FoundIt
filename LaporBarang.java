package com.example.asus.aplikasifoundit;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class LaporBarang extends AppCompatActivity {

    EditText namaCafe, nomorUntukDihubungi, tanggalDitemukan;
    Button laporkan;
    DatabaseReference databaseLaporan;
    String NamaCafe, NomorUntukDihubungi, TanggalDitemukan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lapor_barang);

        namaCafe = (EditText)findViewById(R.id.etNamaCafePenemu);
        nomorUntukDihubungi = (EditText)findViewById(R.id.etWaktuDitemukan);
        tanggalDitemukan = (EditText)findViewById(R.id.etTanggalDitemukan);
        laporkan = (Button)findViewById(R.id.btnLaporkan);

        databaseLaporan = FirebaseDatabase.getInstance().getReference("laporan");

        laporkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ceklaporan();
            }
        });
    }

    private void ceklaporan(){
        String NamaCafe = namaCafe.getText().toString().trim();
        String TanggalDitemukan = tanggalDitemukan.getText().toString().trim();
        String NomorUntukDihubungi = nomorUntukDihubungi.getText().toString().trim();

        if (!TextUtils.isEmpty(NamaCafe)){
          String idLaporan =   databaseLaporan.push().getKey();

            LaporanBarangTinggal laporanBarangTinggal = new LaporanBarangTinggal(idLaporan, NamaCafe, TanggalDitemukan, NomorUntukDihubungi );

            databaseLaporan.child(idLaporan).setValue(laporanBarangTinggal);
            Toast.makeText(LaporBarang.this,"Laporan Berhasil Dibuat",Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(LaporBarang.this, "Masukan data yang diperlukan",Toast.LENGTH_LONG).show();
        }
    }
}
