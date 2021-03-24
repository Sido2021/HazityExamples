package com.example.myapplication.TD.td4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Calendar;

import static android.app.Activity.RESULT_OK;

public class FragmentPersons extends Fragment {

    Person person = null;
    public static int PICK_IMAGE= 101 ;
    ImageView imageView ;
    Bitmap bitmap ;

    public FragmentPersons() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_person, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DataBase db = new DataBase(this.getContext());

        if(getArguments() !=null){
            Bundle args = getArguments();
            int id = args.getInt("id",-1);
            person = db.getPerson(id);
        }

        EditText editTextName = view.findViewById(R.id.edit_text_name);
        DatePicker datePicker = view.findViewById(R.id.datepicker_view_td4);
        imageView = view.findViewById(R.id.image_view_td4);

        Button buttonUpdate = view.findViewById(R.id.button_update);
        ImageButton buttonDelete = view.findViewById(R.id.button_delete);

        if(person != null){
            editTextName.setText(person.name);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(person.birthdate);
            datePicker.updateDate(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
            imageView.setImageBitmap(person.picture);

            imageView.setOnClickListener(v -> {
                Intent i = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, PICK_IMAGE);
            });
        }

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();

                String d = datePicker.getYear()+"-"+(datePicker.getMonth()+1)+"-"+datePicker.getDayOfMonth()  ;
                Date date = Date.valueOf(d);

                Bitmap picture = person.picture; ;
                if(bitmap!=null) picture = bitmap;

                Person p = new Person(person.id,name, date,picture);
                db.updatePerson(p);
                ((ListPersonsActivity)getActivity()).refreshPersons();
            }
        });

        buttonDelete.setOnClickListener(v -> {

            db.deletePerson(person.id);
            ((ListPersonsActivity)getActivity()).loadPersons();
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK
                && null != data) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContext().getContentResolver().openInputStream(imageUri);
                bitmap = BitmapFactory.decodeStream(imageStream);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } else {

        }
    }
}