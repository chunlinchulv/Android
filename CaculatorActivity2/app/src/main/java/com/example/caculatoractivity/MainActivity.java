package com.example.caculatoractivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button_1;
    Button button_2;
    Button button_3;
    Button button_4;
    Button button_5;
    Button button_6;
    Button button_7;
    Button button_8;
    Button button_9;
    Button button_0;
    Button button_AC;
    Button button_add;
    Button button_delete;
    Button button_equal;
    Button button_left;
    Button button_right;
    Button button_divide;
    Button button_multiple;
    Button button_point;
    Button button_minus;
    private TextView text_view;
    private StringBuilder pending=new StringBuilder();

    private void initView() {
         button_1=(Button)findViewById(R.id.button_1);
         button_2=(Button)findViewById(R.id.button_2);
         button_3=(Button)findViewById(R.id.button_3);
         button_4=(Button)findViewById(R.id.button_4);
         button_5=(Button)findViewById(R.id.button_5);
         button_6=(Button)findViewById(R.id.button_6);
         button_7=(Button)findViewById(R.id.button_7);
         button_8=(Button)findViewById(R.id.button_8);
         button_9=(Button)findViewById(R.id.button_9);
         button_0=(Button)findViewById(R.id.button_0);
         button_AC=(Button)findViewById(R.id.button_AC);
         button_add=(Button)findViewById(R.id.button_add);
         button_delete=(Button)findViewById(R.id.button_delete);
         button_equal=(Button)findViewById(R.id.button_equal);
         button_left=(Button)findViewById(R.id.button_left);
         button_right=(Button)findViewById(R.id.button_right);
         button_divide=(Button)findViewById(R.id.button_divide);
         button_multiple=(Button)findViewById(R.id.button_multiple);
         button_point=(Button)findViewById(R.id.button_point);
         button_minus=(Button)findViewById(R.id.button_minus);
        text_view=(TextView) findViewById(R.id.text_view);

        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_AC.setOnClickListener(this);
        button_add.setOnClickListener(this);
        button_delete.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_equal.setOnClickListener(this);
        button_left.setOnClickListener(this);
        button_multiple.setOnClickListener(this);
        button_point.setOnClickListener(this);
        button_right.setOnClickListener(this);
        button_delete.setOnClickListener(this);
        button_minus.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        initView();
        text_view = (TextView) findViewById(R.id.text_view);
        text_view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                text_view.setInputType(InputType.TYPE_NULL);        //关闭软件盘
                return false;
            }
        });
    }
    boolean point=true;
    boolean equal=true;
    boolean zero=true;
    @Override
    public void onClick(View view) {
        int last=0;
        if(pending.length()!=0) {
            last = pending.codePointAt(pending.length() - 1);
        }
        switch (view.getId()) {
            case R.id.button_0:
                if(equal==true) {
                    if(pending.length()!=0&&pending.charAt(pending.length()-1)==')'){
                        pending=pending.append("×");
                    }
                    if(zero==true) {
                        if(pending.length()==0) {
                            zero=false;
                        }
                        pending = pending.append("0");        //延长要被分析的字符串
                        text_view.setText(pending);         //将按钮上显示的内容显示到EditText部分
                    }
                }else {
                    equal=true;
                pending=pending.delete(0,pending.length());
                pending=pending.append("0");
                text_view.setText(pending);
            }
                break;
            case R.id.button_1:
                if(equal==true) {
                    if(pending.length()!=0&&pending.charAt(pending.length()-1)==')'){
                        pending=pending.append("×");
                    }
                    pending = pending.append("1");
                    text_view.setText(pending);
                }else {
                    equal=true;
                    pending=pending.delete(0,pending.length());
                    pending = pending.append("1");
                    text_view.setText(pending);
                }
                break;
            case R.id.button_2:
                if(equal==true) {
                    if(pending.length()!=0&&pending.charAt(pending.length()-1)==')'){
                        pending=pending.append("×");
                    }
                    pending = pending.append("2");
                    text_view.setText(pending);
                }else {
                    equal=true;
                    pending=pending.delete(0,pending.length());
                    pending = pending.append("2");
                    text_view.setText(pending);
                }
                break;
            case R.id.button_3:
                if(equal==true) {
                    if(pending.length()!=0&&pending.charAt(pending.length()-1)==')'){
                        pending=pending.append("×");
                    }
                    pending = pending.append("3");
                    text_view.setText(pending);
                }else {
                    equal=true;
                    pending=pending.delete(0,pending.length());
                    pending = pending.append("3");
                    text_view.setText(pending);
                }
                break;
            case R.id.button_4:
                if(equal==true) {
                    if(pending.length()!=0&&pending.charAt(pending.length()-1)==')'){
                        pending=pending.append("×");
                    }
                    pending = pending.append("4");
                    text_view.setText(pending);
                }else {
                    equal=true;
                    pending=pending.delete(0,pending.length());
                    pending = pending.append("4");
                    text_view.setText(pending);
                }
                break;
            case R.id.button_5:
                if(equal==true) {
                    if(pending.length()!=0&&pending.charAt(pending.length()-1)==')'){
                        pending=pending.append("×");
                    }
                    pending = pending.append("5");
                    text_view.setText(pending);
                }else {
                    equal=true;
                    pending=pending.delete(0,pending.length());
                    pending = pending.append("5");
                    text_view.setText(pending);
                }
                break;
            case R.id.button_6:
                if(equal==true) {
                    if(pending.length()!=0&&pending.charAt(pending.length()-1)==')'){
                        pending=pending.append("×");
                    }
                    pending = pending.append("6");
                    text_view.setText(pending);
                }else {
                    equal=true;
                    pending=pending.delete(0,pending.length());
                    pending = pending.append("6");
                    text_view.setText(pending);
                }
                break;
            case R.id.button_7:
                if(equal==true) {
                    if(pending.length()!=0&&pending.charAt(pending.length()-1)==')'){
                        pending=pending.append("×");
                    }
                    pending = pending.append("7");
                    text_view.setText(pending);
                }else {
                    equal=true;
                    pending=pending.delete(0,pending.length());
                    pending = pending.append("7");
                    text_view.setText(pending);
                }
                break;
            case R.id.button_8:
                if(equal==true) {
                    if(pending.length()!=0&&pending.charAt(pending.length()-1)==')'){
                        pending=pending.append("×");
                    }
                    pending = pending.append("8");
                    text_view.setText(pending);
                }else {
                    equal=true;
                    pending=pending.delete(0,pending.length());
                    pending = pending.append("8");
                    text_view.setText(pending);
                }
                break;
            case R.id.button_9:
                if(equal==true) {
                    if(pending.length()!=0&&pending.charAt(pending.length()-1)==')'){
                        pending=pending.append("×");
                    }
                    pending = pending.append("9");
                    text_view.setText(pending);
                }else {
                    equal=true;
                    pending=pending.delete(0,pending.length());
                    pending = pending.append("9");
                    text_view.setText(pending);
                }
                break;
            case R.id.button_AC:
                point=true;
                equal=true;
                pending=pending.delete(0,pending.length());
                text_view.setText(pending);
                break;
            case R.id.button_add:
                point=true;
                equal=true;
                if(pending.length()!=0) {
                    if(pending.charAt(pending.length()-1)=='×'||pending.charAt(pending.length()-1)=='-'||pending.charAt(pending.length()-1)=='÷'||pending.charAt(pending.length()-1)=='+') {
                        pending=pending.deleteCharAt(pending.length()-1);
                    }
                    pending = pending.append("+");
                }
                text_view.setText(pending);
                break;
            case R.id.button_delete:
                if(pending.length()==0) {
                    return;
                }
                    pending = pending.delete(pending.length() - 1, pending.length());
                text_view.setText(pending);
                break;
            case R.id.button_divide:
                equal=true;
                point=true;
                if(pending.length()!=0) {
                    if(pending.charAt(pending.length()-1)=='+'||pending.charAt(pending.length()-1)=='-'||pending.charAt(pending.length()-1)=='×'||pending.charAt(pending.length()-1)=='÷') {
                        pending=pending.deleteCharAt(pending.length()-1);
                    }
                    pending = pending.append("÷");
                }
                text_view.setText(pending);
                break;
            case R.id.button_multiple:
                point=true;
                equal=true;
                if(pending.length()!=0) {
                    if(pending.charAt(pending.length()-1)=='+'||pending.charAt(pending.length()-1)=='-'||pending.charAt(pending.length()-1)=='÷'||pending.charAt(pending.length()-1)=='×') {
                        pending=pending.deleteCharAt(pending.length()-1);
                    }
                    pending = pending.append("×");
                }
                text_view.setText(pending);
                break;
            case R.id.button_minus:
                point=true;
                equal=true;
                    pending = pending.append("-");
                text_view.setText(pending);
                break;
            case R.id.button_equal:
                point=true;
                if((pending.length()>1)) {
                    InFixInToDuffix inf =new InFixInToDuffix();
                    String result;
                    try {
                        String a=inf.toSuffix(pending);
                        result=inf.dealEquation(a);
                        if(a.length()==0) {
                            result="error";
                        }
                    }catch (Exception ex) {
                        result="error";
                    }
                    text_view.setText(result);
                    pending=pending.delete(0,pending.length());
                    if(Character.isDigit(result.charAt(0))||Character.isDigit(result.charAt(1))) {
                        equal=false;
                        pending=pending.append(result);
                    }
                }
                break;
            case R.id.button_left:
                point=true;
                if(pending.length()>0&&pending.charAt(pending.length()-1)=='-') {
                    pending=pending.append("1×");
                }
                if(pending.length()>0&&pending.charAt(pending.length()-1)>='0'&&pending.charAt(pending.length()-1)<='9'){
                    pending=pending.append("×");
                }
                pending=pending.append("(");
                text_view.setText(pending);
                break;
            case R.id.button_right:
                point=true;
                if(pending.length()!=0) {
                    pending = pending.append(")");
                    text_view.setText(pending);
                }
                break;
            case R.id.button_point:
                zero=true;
                if(pending.length()!=0) {
                    if(point==true) {
                        pending = pending.append(".");
                        text_view.setText(pending);
                    }
                }
                point = false;
                break;
            default:
                break;
        }
        /*Editable text=text_view.getText();
        text_view.setSelection(text.length());
        text_view.requestFocus();*/
    }
}