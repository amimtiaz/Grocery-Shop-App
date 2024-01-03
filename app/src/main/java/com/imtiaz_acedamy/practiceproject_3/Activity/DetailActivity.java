package com.imtiaz_acedamy.practiceproject_3.Activity;

import static java.util.ResourceBundle.getBundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.imtiaz_acedamy.practiceproject_3.Adapter.SimilarAdapter;
import com.imtiaz_acedamy.practiceproject_3.Doamin.ItemsDomain;
import com.imtiaz_acedamy.practiceproject_3.R;

public class DetailActivity extends AppCompatActivity {

    private ItemsDomain object;
    private ImageView backBtn, itemImg;
    private TextView priceKgTxt, titleTxt, descriptionTxt, ratingTxt;
    private RatingBar ratingBar;
    private TextView weightTxt, plusBtn, minusBtn, totalTxt;
    private int weight = 1;
    private RecyclerView.Adapter similarAdapter;
    private RecyclerView recyclerViewSimilar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getBundles();
        initView();
        setVariable();
        initSimilarList();
        
    }

    private void initSimilarList() {

        recyclerViewSimilar = (RecyclerView) findViewById(R.id.similarView);
        recyclerViewSimilar.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        similarAdapter = new SimilarAdapter(new MainActivity().getData());
        recyclerViewSimilar.setAdapter(similarAdapter);

    }

    private void setVariable() {
        backBtn.setOnClickListener(v -> finish());

        int drawableResourceId = getResources().getIdentifier(object.getImgPath(), "drawable", DetailActivity.this.getPackageName());

        Glide.with(DetailActivity.this)
                .load(drawableResourceId)
                .into(itemImg);

        priceKgTxt.setText(object.getPrice()+"$/kg");
        titleTxt.setText(object.getTitle());
        descriptionTxt.setText(object.getDescription());
        ratingTxt.setText(object.getRate()+"");
        ratingBar.setRating((float) object.getRate());
        totalTxt.setText(weight*object.getPrice()+"$");

        plusBtn.setOnClickListener(v -> {

            weight = weight+1;
            weightTxt.setText(weight+" kg");
            totalTxt.setText(weight*object.getPrice()+"$");
        });

        minusBtn.setOnClickListener(v -> {

            if (weight > 1){
                weight = weight - 1;
                weightTxt.setText(weight + " kg");
                totalTxt.setText((weight * object.getPrice())+ "$");
            }

        });

    }

    private void initView() {
        backBtn = (ImageView) findViewById(R.id.backBtn);
        itemImg = (ImageView) findViewById(R.id.img);
        priceKgTxt = (TextView) findViewById(R.id.priceKgTxt);
        titleTxt = (TextView) findViewById(R.id.titleTxt);
        descriptionTxt = (TextView) findViewById(R.id.descriptionTxt);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingTxt = (TextView) findViewById(R.id.ratingTxt);
        weightTxt = (TextView) findViewById(R.id.weightTxt);
        plusBtn = (TextView) findViewById(R.id.plusBtn);
        minusBtn = (TextView) findViewById(R.id.minusBtn);
        totalTxt = (TextView) findViewById(R.id.totalTxt);
        recyclerViewSimilar = (RecyclerView) findViewById(R.id.similarView);
    }

    private void getBundles() {

        object = (ItemsDomain) getIntent().getSerializableExtra("object");

    }
}