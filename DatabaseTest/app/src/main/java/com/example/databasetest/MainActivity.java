package com.example.databasetest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button createDatabase;
    private Button addData;
    private Button updateData;
    private Button deleteData;
    private Button queryData;
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this,"BookStore.db",null,2);
        createDatabase = (Button)findViewById(R.id.create_database);
        addData = (Button)findViewById(R.id.add_data);
        updateData = (Button)findViewById(R.id.update_data);
        deleteData = (Button)findViewById(R.id.delete_data);
        queryData = (Button)findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                //查询Book表中的所有数据
                Cursor cursor = db.query("Book",null,null,null,null,null,null);
                if(cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("MainActivity","book name is "+name);
                        Log.d("MainActivity","book author is "+author);
                        Log.d("MainActivity","book pages is "+pages);
                        Log.d("MainActivity","book price is "+price);
                    }while(cursor.moveToNext());
                }
                cursor.close();
            }
        });
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Book","pages>?",new String[]{"500"});
            }
        });
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price",10.99);
                db.update("Book",values,"name=?",new String[] {"The Da Vinci Code"});
            }
        });
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put("name","The Da Vinci Code");
                values.put("author","Dan Brown");
                values.put("pages",454);
                values.put("price",16.96);
                db.insert("Book",null,values);
                values.clear();

                values.put("name","The lost symbol");
                values.put("author","Dan Brown");
                values.put("pages",516);
                values.put("price",19.95);
                db.insert("Book",null,values);
            }
        });
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });
    }
}
