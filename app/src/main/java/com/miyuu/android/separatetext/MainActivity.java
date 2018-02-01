package com.miyuu.android.separatetext;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String text = "バラバラに表示させるよ";
    String viewText;
    
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView.setTextColor(Color.BLACK);

        handler = new Handler();
        handler.post(new Runnable() {
            int count = -1;
            char data[] = text.toCharArray();
            int textCount = data.length;

            @Override
            public void run() {
                count++;
                if (count < textCount) {
                    viewText = String.valueOf(data[count]);
                    textView.append(viewText);
                    handler.postDelayed(this, 800);
                } else {
                    return;
                }
            }
        });
    }
}


//        public Runnable r = new Runnable() {
//            int count = 0;
//            char data[] = text.toCharArray();
//            int textCount = data.length;
//
//            @Override
//            public void run() {
//                count++;
//                if (count < textCount) {
//                    viewText = String.valueOf(data[i]);
//                    textView.append(viewText);
//                    handler.postDelayed(this, 1000);
//                } else {
//                    return;
//                }
//            }
//
//        };
//        handler.post(r)

