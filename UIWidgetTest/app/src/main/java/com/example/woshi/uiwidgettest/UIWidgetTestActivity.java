package com.example.woshi.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class UIWidgetTestActivity extends AppCompatActivity {
    private EditText editText;
    private ProgressBar progressBar;
    //private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiwidget_test);
        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);
        //imageView=(ImageView) findViewById(R.id.image_view);
        progressBar=(ProgressBar)findViewById(R.id.progress_bar) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //标题的显示
                String inputText = editText.getText().toString();
                Toast.makeText(UIWidgetTestActivity.this, inputText, Toast.LENGTH_SHORT).show();
                //点击按钮图片的切换
                //imageView.setImageResource(R.drawable.img_2);
                //点击按钮进度条得消失与出现
                /*if(progressBar.getVisibility()==View.GONE) {
                    progressBar.setVisibility(View.VISIBLE);
                }else {
                    progressBar.setVisibility(View.GONE);
                }*/

                /*int progress=progressBar.getProgress();
                progress=progress+10;
                progressBar.setProgress(progress);*/

           /*     AlertDialog.Builder dialog=new AlertDialog.Builder(UIWidgetTestActivity.this);
                dialog.setTitle("提示");
                dialog.setMessage("散人是垃圾");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                    }
                });
                dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                    }
                });
                dialog.show();*/
                ProgressDialog progressDialog=new ProgressDialog(UIWidgetTestActivity.this);
                progressDialog.setTitle("正在处理王清杉");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
            }
        });
    }
}
