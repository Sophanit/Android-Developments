package com.example.savingdata.sharedprefference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    public static final String STRING_DEFUAL = "N/A";
    TextView txtName, txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtName = (TextView) findViewById(R.id.usernamenext);
        txtPassword = (TextView) findViewById(R.id.passwordnext);
    }

    public void load(View view) {
//        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
//        String name = sharedPreferences.getString("name", STRING_DEFUAL);
//        String password = sharedPreferences.getString("password",STRING_DEFUAL);
//        if (name.equals(STRING_DEFUAL) || password.equals(STRING_DEFUAL)){
//            Toast.makeText(this, "Data is not loaded", Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            txtName.setText(name);
//            txtPassword.setText(password);
//            Toast.makeText(this, "Data is loaded", Toast.LENGTH_SHORT).show();
//        }
        try {
            FileInputStream fileInputStream = openFileInput("MyData.txt");
            int read = -1;
            StringBuffer stringBuffer = new StringBuffer();
            while ((read = fileInputStream.read()) != -1)
            {
                stringBuffer.append((char) read);
            }
            String name = stringBuffer.substring(0, stringBuffer.indexOf(" "));
            String password = stringBuffer.substring(stringBuffer.indexOf(" ")+1);
            txtName.setText(name);
            txtPassword.setText(password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

        }
    }

    public void previous(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
