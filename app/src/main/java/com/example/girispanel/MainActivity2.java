package com.example.girispanel;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity2 extends AppCompatActivity {

    String gelenAd;
    BottomNavigationView bottomNavim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bottomNavim=findViewById(R.id.bottomnavim);

        Intent gelenintent=getIntent();
        gelenAd=gelenintent.getStringExtra("intentAdi");

       bottomNavim.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                           case R.id.anasayfa:
                               getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler, new homeFrag()).commit();
                               break;

                           case R.id.arama:
                               getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler, new aramaFrag()).commit();


                               break;

                           case R.id.hesabim:
                               getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler, new kisiFrag()).commit();
                               break;
                       }
               return false;
           }
       });

        }

    @Override
    public void onBackPressed() {
        Intent geriIntent = new Intent(MainActivity2.this,MainActivity.class);
        finish();
        startActivity(geriIntent);
    }
}