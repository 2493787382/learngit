package com.example.wold;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainLayoutActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"Call onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Button normalBtn = findViewById(R.id.start_normal_activity);
        normalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainLayoutActivity.this,NormalActivity.class);
                startActivity(intent1);
            }
        });

        Button dialogBtn = findViewById(R.id.start_dialog_activity);
        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String myname = "FHYJY";
                String mynumber = "20191615";
                bundle.putString("name",myname);
                bundle.putString("number",mynumber);
                Intent intent2 = new Intent(MainLayoutActivity.this,DialogActivity.class);
                intent2.putExtra("message",bundle);
                startActivity(intent2);
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"Call onCreate()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"Call onCreate()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"Call onCreate()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"Call onCreate()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Call onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"Call onCreate()");
    }
}
