package com.example.girispanel;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class aramaFrag extends Fragment {

    ListView listem;
    private ArrayAdapter<String> adapter;
    private String [] arama ={"Ev Ürünleri", "Teknoloji Ürünleri", "Çanta Modelleri", "Saat Modelleri" , "Ayakkabı Modelleri" , "Pantolan Modelleri"
    ,"Takım Elbise Modelleri", "Parfüm Çeşitleri", "İç Giyim" , "Şapka Modelleri" , "Makyaj Ürünleri" , "Kitaplar" , "Kırtasiye Ürünleri"};
    private String [] aciklama ={"Dekoratif Eşyalar , Süs Eşyaları , Mobilya Takımları", "Bilgisayar Modelleri , Akıllı Saatler , Telefon Modelleri",
    "Spor Çantalar , Sırt Çantaları , Omuz Çantaları", "Kol Saatleri , Su Geçirmez Kol Saatler , Kuvars Saatler", "" +
            "Spor Ayakkabıları , Koşu Ayakkabıları , Bot & Bootie Ayakkabıları"};

    private int[] resimler={R.drawable.ev1,R.drawable.tek1,R.drawable.sirtcanta,R.drawable.saat1,R.drawable.ayakkabi1};
    private Bitmap sec;







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_arama, container, false);

        listem=view.findViewById(R.id.listem);
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, arama);
        listem.setAdapter(adapter);

        /*listem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();


            }
        });*/

        return view;

    }


}