package com.octans.dev.beautyontime;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import models.ServiceItem;

/**
 * Created by mutabazi on 8/23/16.
 */
public class ServiceListAdapter extends RecyclerView.Adapter<ServiceListAdapter.MyViewHolder> {
    private List<ServiceItem> service;
    Context context;

    public ServiceListAdapter (Context context, List<ServiceItem> service){
        this.context = context;
        this.service = service;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView serviceName;
        public ImageView serviceIcon;
        public MyViewHolder(View itemView) {
            super(itemView);
            serviceName = (TextView) itemView.findViewById(R.id.service_name);
            serviceIcon = (ImageView) itemView.findViewById(R.id.service_icon);
        }
    }

    @Override
    public void onBindViewHolder(ServiceListAdapter.MyViewHolder holder, int position) {
        ServiceItem sItem = service.get(position);

        holder.serviceName.setText(sItem.getService_name());
        holder.serviceIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_content_cut_black_24dp));
    }

    @Override
    public int getItemCount() {
        return service.size();
    }
}
