package com.example.asus.aplikasifoundit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class HalamanBeranda extends Activity {
    private CardView Lapor, Cari, Informasi, Logout;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_beranda);

        firebaseAuth = FirebaseAuth.getInstance();

        Lapor = (CardView)findViewById(R.id.cvLaporkan);
        Cari =  (CardView)findViewById(R.id.cvCari);
        Informasi = (CardView)findViewById(R.id.cvInformasi);
        Logout = (CardView)findViewById(R.id.cvLogout);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(HalamanBeranda.this, login.class));
            }
        });

        Lapor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HalamanBeranda.this, LaporBarang.class));
            }
        });

        Cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HalamanBeranda.this, HalamanHasilCariBarang.class));
            }
        });
    }
}
