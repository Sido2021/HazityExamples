package com.example.myapplication.cours.fragments.exemple1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.myapplication.R;

public class MainActivityFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
    }

    public void onclick(View v){
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction tr = fm.beginTransaction();

        Fragment fragment = null ;

        if(v.getId() == R.id.button_open_fragment1){
            fragment=new MyFragment1();
        }
        if(v.getId() == R.id.button_open_fragment2){
            Bundle bundle = new Bundle();
            bundle.putString("key","Hello world ! ");
            fragment=new MyFragment2();
            fragment.setArguments(bundle);
        }

        if(fragment != null){
            tr.replace(R.id.fragment1,fragment );
            tr.commit();
        }

    }

}