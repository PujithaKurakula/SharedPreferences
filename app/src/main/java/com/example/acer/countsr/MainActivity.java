package com.example.acer.countsr;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;

    TextView tv;
    int i=0;
    Button b1,b2,b3,b4,b5,b6;
    private String spFileName="CountSR";
    private String count_key="countkey";
    private String color_key="colorkey";
    private int colour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textview);
        b1=findViewById(R.id.black);
        b2=findViewById(R.id.red);
        b3=findViewById(R.id.blue);
        b4=findViewById(R.id.green);
        b5=findViewById(R.id.count);
        b6=findViewById(R.id.reset);
        sp=getSharedPreferences(spFileName,MODE_PRIVATE);


            i=sp.getInt(count_key,i);
            tv.setText(String.valueOf(i));
            colour = sp.getInt(color_key, colour);
            //tv.setBackgroundColor(colour);
          if(colour!=0)
          {
            tv.setBackgroundColor(colour);
           }

        }

    public void black(View view) {

      int  colourcode = Color.BLACK;
        tv.setBackgroundColor(colourcode);
        colour=colourcode;
    }

    public void red(View view) {
        int  colourcode= Color.RED;
        tv.setBackgroundColor(colourcode);
        colour=colourcode;
    }

    public void blue(View view) {
       int  colourcode= Color.BLUE;
        tv.setBackgroundColor(colourcode);
        colour=colourcode;
    }

    public void green(View view) {
        int colourcode= Color.GREEN;
        tv.setBackgroundColor(colourcode);
        colour=colourcode;
    }

    public void count(View view) {
        i++;
        tv.setText(String.valueOf(i));
    }

    public void reset(View view) {
        i=0;
        int colourcode=Color.GRAY;
        tv.setText(String.valueOf(i));
        tv.setBackgroundColor(colourcode);
        colour=colourcode;

    }

    @Override
    protected void onPause() {
        super.onPause();
        //i= Integer.parseInt(tv.getText().toString());
      //  colour= Integer.parseInt(tv.getBackground().toString());
        SharedPreferences.Editor editor=sp.edit();
        editor.putInt(count_key,i);
        editor.putInt(color_key,colour);
        editor.apply();
    }
}
