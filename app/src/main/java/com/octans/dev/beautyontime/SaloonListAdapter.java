package com.octans.dev.beautyontime;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.octans.dev.beautyontime.imageLoaderFunctionality.MySingleton;

import java.util.List;

import models.SaloonItems;

/**
 * Created by charl on 20/08/2016.
 */
public class SaloonListAdapter  extends RecyclerView.Adapter<SaloonListAdapter.MyViewHolder> {

    private List<SaloonItems> saloonItems;
    Context context;

    public SaloonListAdapter(Context context, List<SaloonItems> saloonItems) {

        this.saloonItems = saloonItems;
        this.context = context;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView mSaloonName, mSaloonDescription, mSaloonAddress;
        public ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            mSaloonName = (TextView) itemView.findViewById(R.id.saloon_name);
            mSaloonDescription = (TextView) itemView.findViewById(R.id.s_description);
            mSaloonAddress = (TextView) itemView.findViewById(R.id.s_address);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SaloonListAdapter.MyViewHolder holder, int position) {

        ImageLoader mImageLoader;

        SaloonItems mItems = saloonItems.get(position);

        holder.mSaloonName.setText(mItems.getSaloonName());
        holder.mSaloonDescription.setText(mItems.getSaloonDescription());
        holder.mSaloonAddress.setText(mItems.getSaloonAddress());

//        Bitmap bitmapImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.barber_chairs);
//
//        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), bitmapImage);
//        drawable.setCornerRadius(50);
//
//        holder.mImageView.setImageDrawable(drawable);

        // Retrieves an image specified by the URL, displays it in the UI.


// Get the ImageLoader through your singleton class.
        mImageLoader = MySingleton.getInstance(context).getImageLoader();
        mImageLoader.get("http://52.193.252.113"+mItems.getSaloonImage(), ImageLoader.getImageListener(holder.mImageView,
                R.drawable.barber_chairs, R.drawable.barber_chairs));
       // holder.mImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.barber_chairs));
    }

    @Override
    public int getItemCount() {
        return saloonItems.size();
    }


}
