package com.example.test3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FristActivity extends AppCompatActivity {
private final static String TAG = "FristActivity";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                String msg = data.getStringExtra("msg");
                Log.d(TAG,"msg="+msg);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frist_layout);



        Button button1 = findViewById(R.id.Button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setData(Uri.parse("tel:13850674224"));
//                startActivity(intent);

//                Intent intent = new Intent(FristActivity.this,SecondActivity.class);//模拟传递一个类的对象
//                startActivityForResult(intent,1);
                Intent intent = new Intent(FristActivity.this,SecondActivity.class);
                Bundle bundle = new Bundle();
                Account msg = new Account("张三","M",20);
                bundle.putParcelable("msg",msg);
                intent.putExtra("message",bundle);
                startActivity(intent);

            }
        });
    }
}
