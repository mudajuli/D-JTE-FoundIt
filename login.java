package com.example.asus.aplikasifoundit;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    private EditText Nama;
    private EditText Password;
    private TextView Daftar;
    private Button Login;
    private TextView Info;
    private FirebaseAuth firebaseAuth;
    //membuat field utk semua elemen yang ada di dalam file .xml agar bisa diinisiasikan

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Nama = (EditText) findViewById(R.id.etUsername);
        Password = (EditText) findViewById(R.id.etPassword);
        Daftar = (TextView) findViewById(R.id.tvRegister);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);
        //menginisiasikan dengan objek-objek di dalam file .xml sesuai dengan ID nya masing-masing

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user !=null){
            finish();
            startActivity(new Intent(login.this, com.example.asus.aplikasifoundit.HalamanBeranda.class));
        }


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Nama.getText().toString(), Password.getText().toString());


            }
        });

        Daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, com.example.asus.aplikasifoundit.Daftar.class));
                //memindahkan user dari halaman login ke halaman registrasi saat link pendaftaran akun di klik.
            }
        });

    }

    private void validate(final String userName, final String userPassword) {


        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login.this, com.example.asus.aplikasifoundit.HalamanBeranda.class));
                }else{
                    Toast.makeText(login.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }

            }
        });


        }
    }
