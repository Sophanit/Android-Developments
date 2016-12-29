package com.example.savingdata.sharedprefference;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FileStorage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage);
    }

    public void internalCache(View view) {
    }

    public void externalCache(View view) {
    }

    public void externalPrivate(View view) {
    }

    public void externalPublic(View view) {
    }

    public void nextOne(View view) {
        startActivity(new Intent(this, LoadActivity.class));
    }
}
