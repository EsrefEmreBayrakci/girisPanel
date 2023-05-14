package com.example.girispanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView logo;
    RelativeLayout panelim;

    Button btngiris, btnkayit;
    EditText kAdi,kSifre;
    String kullaniciAdi,kullaniciSifre,dogruAd="Eşref Emre",dogruSifre="12345";

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo=findViewById(R.id.logo);
        panelim=findViewById(R.id.panelim);
        btngiris=findViewById(R.id.btngiris);
        kAdi=findViewById(R.id.kAdi);
        kSifre=findViewById(R.id.kSifre);
        btnkayit=findViewById(R.id.btnkayit);

        Animation anim1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo);
        Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.panelanim);
        logo.startAnimation(anim1);
        panelim.startAnimation(anim2);

        try {
            db=this.openOrCreateDatabase("login",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS person (Id INTEGER PRIMARY KEY, ad VARCHAR, sifre VARCHAR)");
        }catch (Exception e){
            e.printStackTrace();

        }







        btngiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kullaniciAdi=kAdi.getText().toString();
                kullaniciSifre=kSifre.getText().toString();
                if(!TextUtils.isEmpty(kullaniciAdi) && !TextUtils.isEmpty(kullaniciSifre)){
                    if(kullaniciAdi.equals(dogruAd) && kullaniciSifre.equals(dogruSifre)){
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        intent.putExtra("intentAdi",kullaniciAdi);
                        finish();
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(MainActivity.this, "Kullanıcı adı veya şifre hatalı", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Kullanıcı adı veya şifre boş olamaz", Toast.LENGTH_SHORT).show();
            }
        });

        btnkayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(MainActivity.this,MainActivity3.class);
                finish();
                startActivity(intent1);
            }
        });
    }
}