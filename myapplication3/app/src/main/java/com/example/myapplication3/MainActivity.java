package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LitePal.initialize(this);
        SQLiteDatabase db = Connector.getDatabase();
    }
}
