package com.abhishekchoksi.internalstorageapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileActivity extends AppCompatActivity {
    Button btnWrite;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_file);

        btnWrite = findViewById(R.id.btnWrite);
        editText = findViewById(R.id.editText);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fOut = openFileOutput("info.txt", Context.MODE_PRIVATE);
                    // String str = "Hello Abhishek";
                    String str = editText.getText().toString();
                    if(str != null || !str.isEmpty()) {
                        fOut.write(str.getBytes());
                        fOut.close();
                        Toast.makeText(WriteFileActivity.this, "File Write Successfully", Toast.LENGTH_SHORT).show();
                        editText.setText("");
                    }
                    else
                    {
                        editText.setError( "Enter Text is required!" );
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}