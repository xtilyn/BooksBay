package com.xtilyna.booksbay.booksbay.menu.ui;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.entities.MenuItem;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView name;

        public MenuViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.list_item_menu_icon);
            name = (TextView) itemView.findViewById(R.id.list_item_menu_name);
        }
    }

    List<MenuItem> data;
    LayoutInflater inflater;
    Context context;


    public MenuAdapter(Context context, List<MenuItem> data) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_menu, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        MenuItem current = data.get(position);
        holder.name.setText(current.getName());
        Picasso.with(context).load(current.getIconId()).fit().into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
