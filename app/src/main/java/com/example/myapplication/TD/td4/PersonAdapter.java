package com.example.myapplication.TD.td4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class PersonAdapter extends BaseAdapter {
    Context context ;
    ArrayList<Person> persons ;

    PersonAdapter(Context context , ArrayList<Person> persons){
        this.context = context ;
        this.persons = persons;
    }

    void setPersons(ArrayList<Person> persons){
        this.persons=persons;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.layout_person,parent,false);

        ImageView imageView = v.findViewById(R.id.image_view_td4_adapter);
        TextView textViewName = v.findViewById(R.id.text_view_name_td4_adapter);
        TextView textViewBirthdate = v.findViewById(R.id.text_view_birthdate_td4_adapter);

        imageView.setImageBitmap(persons.get(position).picture);
        textViewName.setText(persons.get(position).name);
        textViewBirthdate.setText(persons.get(position).birthdate.toString());

        return v;
    }
}
