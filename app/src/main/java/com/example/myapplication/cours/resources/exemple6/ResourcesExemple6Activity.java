package com.example.myapplication.cours.resources.exemple6;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class ResourcesExemple6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_exemple6);

        TextView  mAffichageCompteur = (TextView) findViewById(R.id.text_view_resource_ex6);
        ConnectivityManager cm = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        boolean wifi = ni.getType() == ConnectivityManager.TYPE_WIFI;
        mAffichageCompteur.setText("le wifi : " + wifi);

    }
}