package com.example.girispanel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class kisiFrag extends Fragment {

    EditText adi1,adi,sifre,sifre1;

    String kuladi,kulsifre;

    Button btnguncelle;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_kisi, container, false);

        adi=view.findViewById(R.id.adi);
        adi1=view.findViewById(R.id.adi1);
        sifre=view.findViewById(R.id.sifre);
        sifre1=view.findViewById(R.id.sifre1);
        btnguncelle=view.findViewById(R.id.btnguncelle);

        btnguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kuladi=adi.getText().toString();
                kulsifre=sifre.getText().toString();

                if(!TextUtils.isEmpty(kuladi) && !TextUtils.isEmpty(kulsifre)){
                        adi1.setText(kuladi);
                        sifre1.setText(kulsifre);
                    Toast.makeText(getActivity(), "Bilgiler güncellendi", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity(), "Kullanıcı adı ve Şifre boş bırakılamaz", Toast.LENGTH_SHORT).show();
                }


            }
        });




        return view;
    }
}