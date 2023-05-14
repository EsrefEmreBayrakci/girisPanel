package com.example.girispanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Button btnkayit;

   EditText adi,sifre;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnkayit=findViewById(R.id.btnkayit);
        adi=findViewById(R.id.adi);
        sifre=findViewById(R.id.sifre);



        try {
            db=this.openOrCreateDatabase("login",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS person (Id INTEGER PRIMARY KEY, ad VARCHAR, sifre VARCHAR)");
        }catch (Exception e){
            e.printStackTrace();

        }

    }




    public void sqlprog(View view) {

        switch (view.getId()){
            case R.id.btnkayit:
                try {
                    db.execSQL("INSERT INTO person(ad,sifre) VALUES ('"+adi.getText().toString()+"','"+sifre.getText().toString()+"')");
                    Toast.makeText(this, "Kullanıcı Eklendi", Toast.LENGTH_SHORT).show();
                    adi.setText("");
                    sifre.setText("");
                }catch (Exception e){

                }
                break;
        }
    }

    public void onBackPressed() {
        Intent geriIntent = new Intent(MainActivity3.this,MainActivity.class);
        finish();
        startActivity(geriIntent);
    }


}