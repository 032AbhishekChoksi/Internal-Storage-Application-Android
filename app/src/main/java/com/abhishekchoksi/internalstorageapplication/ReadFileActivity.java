package com.abhishekchoksi.internalstorageapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_file);

        textView = findViewById(R.id.textView);

        try {
            FileInputStream fIn = openFileInput("info.txt");
            int c;
            String temp = "";
            while((c = fIn.read()) != -1){
                temp = temp + Character.toString((char) c);
            }
            fIn.close();

            textView.setText(temp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}