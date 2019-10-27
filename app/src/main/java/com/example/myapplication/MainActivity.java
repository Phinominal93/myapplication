package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText nameEditText,surnameEditText,marksEditText;
    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DataBaseHelper(this);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        surnameEditText = (EditText) findViewById(R.id.surnameEditText);
        marksEditText = (EditText) findViewById(R.id.marksEditText);
        addBtn = (Button) findViewById(R.id.addBtn);
    }

    public void AddData() {
        addBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                     boolean isInserted = myDb.insertData(nameEditText.getText().toString(),
                                surnameEditText.getText().toString(),
                                marksEditText.getText().toString());
                        if(isInserted = true)
                            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}
