package com.example.savingdata.sharedprefference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText txtUsername, txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsername = (EditText) findViewById(R.id.username);
        txtPassword = (EditText) findViewById(R.id.password);
    }

    public void save(View view) {
//        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("name", txtUsername.getText().toString());
//        editor.putString("password", txtPassword.getText().toString());
//        editor.commit();
        File file = null;
        FileOutputStream fileOutputStream = null;
        String name = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();
        name = name + " ";
        try {
            file = getFilesDir();
            fileOutputStream = openFileOutput("MyData.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(name.getBytes());
            fileOutputStream.write(password.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        txtUsername.setText("");
        txtPassword.setText("");
        Toast.makeText(this, "Data is saved in " + file + "/MyData.txt", Toast.LENGTH_SHORT).show();
    }

    public void next(View view) {
        startActivity(new Intent(this, Main2Activity.class));
    }
}

