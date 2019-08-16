package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
//        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter=new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruits() {
        for(int i=0;i<2;i++) {
            Fruit apple=new Fruit(getRandomLengthName("apple"),R.drawable.apple);
            fruitList.add(apple);
            Fruit banana=new Fruit("banana",R.drawable.banana);
            fruitList.add(banana);
            Fruit cherry=new Fruit("cherry",R.drawable.cherry);
            fruitList.add(cherry);
            Fruit grape=new Fruit("grape",R.drawable.grape);
            fruitList.add(grape);
            Fruit mango=new Fruit("mango",R.drawable.mango);
            fruitList.add(mango);
            Fruit orange=new Fruit("orange",R.drawable.orange);
            fruitList.add(orange);
            Fruit pear=new Fruit("pear",R.drawable.pear);
            fruitList.add(pear);
            Fruit pineapple=new Fruit("pineapple",R.drawable.pineapple);
            fruitList.add(pineapple);
            Fruit strawberry=new Fruit("strawberry",R.drawable.strawberry);
            fruitList.add(strawberry);
            Fruit watermelon=new Fruit("watermelon",R.drawable.watermelon);
            fruitList.add(watermelon);
        }
    }

    private String getRandomLengthName(String name) {
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<length;i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}
