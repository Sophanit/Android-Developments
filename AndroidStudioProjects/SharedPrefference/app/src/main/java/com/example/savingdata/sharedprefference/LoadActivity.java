package com.example.savingdata.sharedprefference;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
    }

    public void loadInternalCache(View view) {
    }

    public void loadEnternalCache(View view) {
    }

    public void previous(View view) {
        startActivity(new Intent(this, FileStorage.class));
    }
}
