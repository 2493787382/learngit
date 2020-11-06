package com.example.wold;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener,CompoundButton.OnCheckedChangeListener{
    private ProgressBar progressBar;
    private EditText usernameView;
    private TextView resultView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp);
//        mountainArray = getResources().getStringArray(R.array.visit_place);
        initView();
    }
private void initView(){
//    TextView placeLabelView = findViewById(R.id.)

    RadioGroup rg = findViewById(R.id.visit);
    rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int i) {
            int index = -1;
            if(i == R.id.place1){
                index = 0;
            }else if(i == R.id.place2){
                index = 1;
            }else if(i == R.id.place3){
                index = 2;
            }else if(i == R.id.place4){
                index = 3;
            }
            if(index >= 0){
                showUIToast(""+index);
            }
        }
    });
    CheckBox badmintonView = findViewById(R.id.badminton_view);
    CheckBox basketballView =  findViewById(R.id.ball_view);
    badmintonView.setOnCheckedChangeListener(this);
    basketballView.setOnCheckedChangeListener(this);

    progressBar =  findViewById(R.id.progressBar);
    Button plusView = findViewById(R.id.plus_view);
    Button substractView = findViewById(R.id.substract_view);
    plusView.setOnClickListener(this);
    substractView.setOnClickListener(this);

    usernameView =  findViewById(R.id.username);
    Button submitView = findViewById(R.id.submit);
    submitView.setOnClickListener(this);

    resultView = findViewById(R.id.result);
}
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.plus_view:
                updateProgressView(true);
                break;
            case R.id.substract_view:
                updateProgressView(false);
                break;
            case R.id.submit:
                onSubmitConfirm();
            default:
                break;
        }
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
    private  void updateProgressView(boolean plus){
        int progress = progressBar.getProgress();
        if(plus){
            progress += 10;
            if(progress > 100){
                progress = 100;
            }
        }else{
            progress -= 10;
            if(progress < 0){
                progress = 0;
            }
        }
        progressBar.setProgress(progress);
    }
    private void onSubmitConfirm(){
        AlertDialog dlg;
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("普通对话框")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("是否确定提交？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                        onSubmit();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dlg = builder.create();
        dlg.show();
    }
    private void onSubmit(){
        StringBuffer sb = new StringBuffer();
        String username = usernameView.getText().toString();
        if (username != null && !username.isEmpty()){
            sb.append("\n by "+username);
        }
        resultView.setText(sb.toString());
    }
private void showUIToast(final String info){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(FirstActivity.this, ""+info,
                Toast.LENGTH_LONG).show();
            }
        });
}
}
