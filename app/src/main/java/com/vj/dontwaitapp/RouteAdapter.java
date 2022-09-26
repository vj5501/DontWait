package com.vj.dontwaitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.RouteViewHolder> {

    Context context;
    ArrayList<Route> routeArrayList;

    public RouteAdapter(Context context, ArrayList<Route> routeArrayList) {
        this.context = context;
        this.routeArrayList = routeArrayList;
    }

    @NonNull
    @Override
    public RouteAdapter.RouteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new RouteViewHolder (v);
    }

    @Override
    public void onBindViewHolder(@NonNull RouteAdapter.RouteViewHolder holder, int position) {

        Route route = routeArrayList.get(position);
        holder.source.setText(route.Source);
        holder.destination.setText(route.Destination);
        holder.busNo.setText(String.valueOf(route.BusNo));
        holder.leavingTime.setText(route.LeavingTime);
    }

    @Override
    public int getItemCount() {
        return routeArrayList.size()    ;
    }
    public static class RouteViewHolder extends RecyclerView.ViewHolder{

        TextView source,destination,busNo,leavingTime;


        public RouteViewHolder(@NonNull View itemView) {
            super(itemView);

            source=itemView.findViewById(R.id.tvSource);
            destination=itemView.findViewById(R.id.tvDestination);
            busNo=itemView.findViewById(R.id.tvBusn);
            leavingTime=itemView.findViewById(R.id.tvTime);
        }
    }
}