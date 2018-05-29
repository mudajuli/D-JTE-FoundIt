package com.example.asus.aplikasifoundit;

import android.content.Intent;
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

public class Daftar extends AppCompatActivity {

    private EditText NamaUser;
    private EditText PasswordUser;
    private EditText EmailUser;
    private Button DaftarUser;
    private TextView LoginUser;
    private FirebaseAuth firebaseAuth;
    //membuat field untuk semua elemen yang ada di dalam file .xml agar bisa diinisiasikan

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        DaftarUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    //Upload data to the database
                    String email_user = EmailUser.getText().toString().trim();
                    String password_user = PasswordUser.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(email_user, password_user).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                //sendEmailVerification();

                                firebaseAuth.signOut();
                                Toast.makeText(Daftar.this, "Proses Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(Daftar.this, login.class));
                            }else{
                                Toast.makeText(Daftar.this, "Terjadi Kesalahan. Proses Registrasi Gagal", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });



    }

    private void setupUIViews(){
        NamaUser = (EditText)findViewById(R.id.etNamaUser);
       PasswordUser = (EditText)findViewById(R.id.etPasswordUser);
        EmailUser = (EditText)findViewById(R.id.etEmailUser);
        DaftarUser = (Button)findViewById(R.id.btnDaftarUser);

    }



    private Boolean validate(){
        Boolean result = false;

      String nama = NamaUser.getText().toString();
      String password = PasswordUser.getText().toString();
      String email = EmailUser.getText().toString();




        if(nama.isEmpty() || password.isEmpty() || email.isEmpty()){
            Toast.makeText(this, "Tolong Masukan Semua Detail Yang Diperlukan", Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }

        return result;
    }

        }


