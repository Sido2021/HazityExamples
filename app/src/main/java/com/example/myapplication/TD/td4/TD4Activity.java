package com.example.myapplication.TD.td4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Calendar;

public class TD4Activity extends AppCompatActivity {

    Button buttonAdd ;
    ImageButton buttonOpen ;
    EditText editTextName ;
    CalendarView calendarView ;
    ImageView imageView ;
    Bitmap bitmap ;

    public static final int PICK_IMAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td_4);

        DataBase db = new DataBase(this);

        editTextName = findViewById(R.id.edit_text_name);
        calendarView = findViewById(R.id.calendar_view_td4);
        imageView = findViewById(R.id.image_view_td4);

        buttonAdd =findViewById(R.id.button_add);
        buttonOpen = findViewById(R.id.button_open_list);

        buttonAdd.setOnClickListener(v -> {
            String name = editTextName.getText().toString();

            long d = calendarView.getDate();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(d);
            int Year = calendar.get(Calendar.YEAR);
            int Month = calendar.get(Calendar.MONTH);
            int Day = calendar.get(Calendar.DAY_OF_MONTH);

            Date date = Date.valueOf(Year+"-"+Month+"-"+Day);

            Person p = new Person(name,date,bitmap);

            db.insertPerson(p);
        });
        buttonOpen.setOnClickListener(v -> {
            startActivity(new Intent(TD4Activity.this,ListPersonsActivity.class));
        });

        imageView.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK
                && null != data) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                bitmap = BitmapFactory.decodeStream(imageStream);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        } else {

        }
    }
}