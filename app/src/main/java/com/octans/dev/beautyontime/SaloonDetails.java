package com.octans.dev.beautyontime;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.octans.dev.beautyontime.imageLoaderFunctionality.MySingleton;

import java.util.ArrayList;
import java.util.List;

import models.ServiceItem;

public class SaloonDetails extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbarLayout;
    private String itemTitle;
    private String saloonId;
    private String saloonImage;

    private ImageView mSaloonImage;

    private Context context;

    //1. initialize recyclerview, list (basing on the model and the adapter)
    private RecyclerView mRecyclerView;
    private List<ServiceItem> mServiceList = new ArrayList<>();
    private ServiceListAdapter mServiceAdapter;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saloon_details);

        getWindow().setStatusBarColor(Color.TRANSPARENT);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //get extras from privious activity
        Intent intent = getIntent();

        //get data from inte extra
        itemTitle = intent.getStringExtra("salooname");
        saloonId = intent.getStringExtra("saloonId");
        saloonImage = intent.getStringExtra("saloonImage");

        mSaloonImage = (ImageView) findViewById(R.id.image);

        //2. set the recycler view reffering to the layout
        mRecyclerView = (RecyclerView) findViewById(R.id.serviceListView);

        //3. set the adapter with args getApplicationContext and List declared above
        mServiceAdapter = new ServiceListAdapter(getApplicationContext(), mServiceList);

        //4. Setting list layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(mServiceAdapter);

        // Retrieves an image specified by the URL, displays it in the UI.
        ImageRequest request = new ImageRequest("http://52.193.252.113"+saloonImage,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        mSaloonImage.setImageBitmap(bitmap);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        mSaloonImage.setImageResource(R.drawable.barber_chairs);
                    }
                });
// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(request);



        //ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), EXTRA_IMAGE);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(itemTitle);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));


        LoadServiceItems loadServiceItems = new LoadServiceItems();
        loadServiceItems.execute();

    }

    private class LoadServiceItems extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... params) {
            ServiceItem sLogs1 = new ServiceItem("Icon_Barber", "Hair Cutting");
            ServiceItem sLogs2 = new ServiceItem("Icon_Hand", "Pedicure/Manicure");
            ServiceItem sLogs3 = new ServiceItem("Icon_Hand2", "Hair Dressing");
            ServiceItem sLogs4 = new ServiceItem("Icon_Hand3", "Pedicure/Manicure2");

            mServiceList.add(sLogs1);
            mServiceList.add(sLogs2);
            mServiceList.add(sLogs3);
            mServiceList.add(sLogs4);
            return null;
        }
    }
}
