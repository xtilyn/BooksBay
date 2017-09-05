package com.xtilyna.booksbay.booksbay.menu.ui;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xtilyna.booksbay.booksbay.entities.MenuItem;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        public MenuViewHolder(View itemView) {
            super(itemView);
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
        return null;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
