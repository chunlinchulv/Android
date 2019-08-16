package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    private String[] data = {"apple", "banana", "orange", "watermelon", "pear", "grape", "pineapple", "strawberry", "cherry", "mango", "apple", "banana", "orange", "watermelon", "pear", "grape", "pineapple", "strawberry", "cherry", "mango"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruit();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        ListView listView=(ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit=fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void initFruit() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("apple", R.drawable.apple);
            fruitList.add(apple);
            Fruit banana = new Fruit("banana", R.drawable.banana);
            fruitList.add(banana);
            Fruit cherry = new Fruit("cherry", R.drawable.cherry);
            fruitList.add(cherry);
            Fruit grape = new Fruit("grape", R.drawable.grape);
            fruitList.add(grape);
            Fruit mango = new Fruit("mango", R.drawable.mango);
            fruitList.add(mango);
            Fruit orange = new Fruit("orange", R.drawable.orange);
            fruitList.add(orange);
            Fruit pear = new Fruit("pear", R.drawable.pear);
            fruitList.add(pear);
            Fruit pineapple = new Fruit("pineapple", R.drawable.pineapple);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("strawberry", R.drawable.strawberry);
            fruitList.add(strawberry);
            Fruit watermelon = new Fruit("watermelon", R.drawable.watermelon);
            fruitList.add(watermelon);
        }
    }
}
