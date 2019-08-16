package com.example.woshi.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HelloWorldActivity extends BaseActivity {

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this,"You Clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You Click Remove",Toast.LENGTH_SHORT).show();
                break;
                default:
        }
        return true;
    }

   @Override
  public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    Log.d("HelloWorldActivity", returnData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("HelloWorldActivity","onRestart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("HelloWorldActivity","Task id id"+getTaskId());
//        Log.d("HelloWorldActivity",this.toString());
        setContentView(R.layout.activity_hello_world);
        Button button1=(Button) findViewById(R.id.button_1) ;
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(HelloWorldActivity.this,"You Pressed it",Toast.LENGTH_LONG).show();
//                finish();
//                Intent intent=new Intent(HelloWorldActivity.this,SecondActivity.class);
                /*Intent intent=new Intent("com.example.woshi.helloworld.ACTION_START");
                intent.addCategory("com.example.woshi.helloworld.MY_CATEGORY");*/

               /* Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"));*/
               /*String data="Hello SecondActivity";
               Intent intent=new Intent(HelloWorldActivity.this,SecondActivity.class);
               intent.putExtra("extra_data",data);
               startActivity(intent);*/
               /*Intent intent=new Intent(HelloWorldActivity.this,SecondActivity.class);
               startActivityForResult(intent,1);*/
               Intent intent=new Intent(HelloWorldActivity.this,SecondActivity.class);
               startActivity(intent);
            }
        });
        //Log.d("HelloWorld!","onCreat execute");

    }
}
