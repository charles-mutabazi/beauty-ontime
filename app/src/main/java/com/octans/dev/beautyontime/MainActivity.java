package com.octans.dev.beautyontime;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.octans.dev.beautyontime.httpManager.HTTPManager;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jsonParser.JsonParser;
import models.SaloonItems;

public class MainActivity extends AppCompatActivity {

    private ImageView mImage;
    private Context context;
    private static final int VERTICAL_ITEM_SPACE = 20;

    private RecyclerView mRecyclerView;
    private List<SaloonItems> saloonList = new ArrayList<>();
    private SaloonListAdapter mSaloonAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.listView);

        mSaloonAdapter = new SaloonListAdapter(getApplicationContext(), saloonList);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //draw a line between list elements
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(getApplicationContext(), R.drawable.divider));


        mRecyclerView.setAdapter(mSaloonAdapter);

        //attach on touch and long touch listeners on the list items
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(), mRecyclerView, new RecyclerItemClickListener.OnItemClickListener(){

            @Override
            public void onItemClick(View view, int position) {
                //create new activity intent with the SaloonDetails class
                Intent detailsIntent = new Intent(MainActivity.this, SaloonDetails.class);
                detailsIntent.putExtra("salooname", saloonList.get(position).getSaloonName());
                detailsIntent.putExtra("saloonId", saloonList.get(position).getSaloonId());
                detailsIntent.putExtra("saloonImage", saloonList.get(position).getSaloonImage());
                //use the created intent to go the saloon details activity
                startActivity(detailsIntent);
            }
            @Override
            public void onLongItemClick(View view, int position) {

            }
        }
        ));

        LoadSaloonItems load = new LoadSaloonItems();
        load.execute("http://52.193.252.113/places");

    }

    private class LoadSaloonItems extends AsyncTask<String, Void, String>{


        @Override
        protected String doInBackground(String... params) {
            try {
                String saloon_data = HTTPManager.getSaloonsData(params[0]);
                return saloon_data;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            Log.d("MainActivity:", s);
            try {
                saloonList.addAll(JsonParser.ParseSaloonsJsonData(s));
                mSaloonAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
