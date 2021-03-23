package com.example.myapplication.TD.td4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.cours.fragments.exemple1.MyFragment1;
import com.example.myapplication.cours.fragments.exemple1.MyFragment2;

import java.util.ArrayList;

public class ListPersonsActivity extends AppCompatActivity {

    ListView listViewPersons ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_persons);

        DataBase db = new DataBase(this);
        listViewPersons = findViewById(R.id.list_view_persons);

        ArrayList<Person> persons = db.getPersons();

        ArrayAdapter<Person> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,persons);
        listViewPersons.setAdapter(adapter);

        listViewPersons.setOnItemClickListener((parent, view, position, id) -> {
            Person p = persons.get(position);

            FragmentManager fm= getSupportFragmentManager();
            FragmentTransaction tr = fm.beginTransaction();

            Fragment fragment=new FragmentPersons();

            Bundle bundle = new Bundle();
            bundle.putSerializable("person",p);

            fragment.setArguments(bundle);
            tr.replace(R.id.fragment_person,fragment );
            tr.commit();
        });
    }
}