package com.example.myapplication.TD.td1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myapplication.R;

public class TD1Activity extends AppCompatActivity {
    ProgressBar bar;
    TextView textView;
    int number = 0 ;

    Handler handler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            int p = bar.getProgress() ;
            bar.setProgress(++p);

            int i= msg.what;
            textView.setText(textView.getText().toString()+i+",");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td1);

        textView = findViewById(R.id.text_view_td1);
        Button button  = findViewById(R.id.button_td1);
         bar = findViewById(R.id.bar_td1);
        EditText editText = findViewById(R.id.edit_text_td1);




        button.setOnClickListener(v -> {
            try{
                number = Integer.parseInt(editText.getText().toString());
                bar.setMax(number);
                bar.setProgress(0);
                textView.setText("Prime numbers :");
                startThread();
            }catch(Exception e){e.printStackTrace(); }
        });
    }

    private  void startThread(){
        Thread thread = new Thread(()->{
            try {
                for(int i=2;i< number ;i++){
                    if(isPrimeNumber(i)){
                        Thread.sleep(1000);
                        handler.sendEmptyMessage(i);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
    private boolean isPrimeNumber(int n) {
        for(int j = 2;j < n;j++){
            if(n%j ==0 ){
                return false;
            }
        }
        return true ;
    }
}