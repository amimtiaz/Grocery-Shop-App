package com.imtiaz_acedamy.practiceproject_3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.imtiaz_acedamy.practiceproject_3.Adapter.BestDealAdapter;
import com.imtiaz_acedamy.practiceproject_3.Adapter.CategoryAdapter;
import com.imtiaz_acedamy.practiceproject_3.Doamin.CategoryDomain;
import com.imtiaz_acedamy.practiceproject_3.Doamin.ItemsDomain;
import com.imtiaz_acedamy.practiceproject_3.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter catAdapter, bestDealAdapter;
    private RecyclerView catView,bestView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerViewCart();

        initLocation();
        initRecyclerViewBestDeal();


    }

    private void initLocation() {

        String[] items = new String[]{"LosAngles, USA", "NewYork, USA"};
        final Spinner locationSpin = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpin.setAdapter(adapter);

    }



    private void xM(){
        String[] items = new String[]{"losAngles", "NewYork"};
        final  Spinner locationSpin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        locationSpin.setAdapter(adapter);
    }

    private void intiLoc(){
        String[]  items = new String[]{"los", "USA"};
        final Spinner locationSpin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String>  adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        locationSpin.setAdapter(adapter);
    }


    private void initRecyclerViewCart() {

        ArrayList<CategoryDomain> items = new ArrayList<>();
        items.add(new CategoryDomain("cat1", "Vegetable"));
        items.add(new CategoryDomain("cat2", "Fruits"));
        items.add(new CategoryDomain("cat3", "Dairy"));
        items.add(new CategoryDomain("cat4", "Drinks"));
        items.add(new CategoryDomain("cat5", "Grain"));

        catView = (RecyclerView) findViewById(R.id.catView);
        catView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        catAdapter = new CategoryAdapter(items);
        catView.setAdapter(catAdapter);

    }

    private void initRecyclerViewBestDeal(){
        bestView = findViewById(R.id.bestView);
        bestView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        bestDealAdapter = new BestDealAdapter(getData());
        bestView.setAdapter(bestDealAdapter);
    }


    public ArrayList<ItemsDomain> getData(){
        ArrayList<ItemsDomain> items = new ArrayList<>();
        items.add(new ItemsDomain("orange","Fresh Orange",6.2,"French multinational telecommunications corporation. It has 266 million customers worldwide and employs 89,000 people in France and 59,000 people elsewhere. In 2015, the group had a revenue of €40 billion. The company's head office is located in Issy-les-Moulineaux.",4.2));

        items.add(new ItemsDomain("apple","Fresh Apple",3.5,"French multinational telecommunications corporation. It has 266 million customers worldwide and employs 89,000 people in France and 59,000 people elsewhere. In 2015, the group had a revenue of €40 billion. The company's head office is located in Issy-les-Moulineaux.",4.6));

        items.add(new ItemsDomain("watermelon","Fresh Watermelon",2.7,"French multinational telecommunications corporation. It has 266 million customers worldwide and employs 89,000 people in France and 59,000 people elsewhere. In 2015, the group had a revenue of €40 billion. The company's head office is located in Issy-les-Moulineaux.",4.2));

        items.add(new ItemsDomain("berry","Fresh Berry",8.0,"French multinational telecommunications corporation. It has 266 million customers worldwide and employs 89,000 people in France and 59,000 people elsewhere. In 2015, the group had a revenue of €40 billion. The company's head office is located in Issy-les-Moulineaux.",4.2));

        items.add(new ItemsDomain("pineaplle","Fresh Pineapple",9.6,"French multinational telecommunications corporation. It has 266 million customers worldwide and employs 89,000 people in France and 59,000 people elsewhere. In 2015, the group had a revenue of €40 billion. The company's head office is located in Issy-les-Moulineaux.",4.2));

        items.add(new ItemsDomain("strawberry","Fresh Strawberry",5.4,"French multinational telecommunications corporation. It has 266 million customers worldwide and employs 89,000 people in France and 59,000 people elsewhere. In 2015, the group had a revenue of €40 billion. The company's head office is located in Issy-les-Moulineaux.",4.2));
        return items;

    }




}