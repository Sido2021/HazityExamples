package com.example.myapplication.cours.fragments.exemple1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class MyFragment2 extends Fragment {

    public MyFragment2() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String arg1 = "";
        if(getArguments() !=null){
            Bundle args = getArguments();
            arg1 = args.getString("key","null");
        }

        TextView textView = view.findViewById(R.id.text_view_fragment_ex2);
        textView.setText(arg1);
    }
}