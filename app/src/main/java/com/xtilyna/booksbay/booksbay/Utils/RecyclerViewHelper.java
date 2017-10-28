package com.xtilyna.booksbay.booksbay.Utils;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class RecyclerViewHelper {

    public final static int LINEAR_VERTICAL = 0;
    public final static int LINEAR_HORIZONTAL = 1;
    public final static int GRID = 2;

    public static void setupRecyclerView(
            Context context,
            RecyclerView recyclerView,
            int layoutType,
            RecyclerView.Adapter adapter) {

        recyclerView.setAdapter(adapter);
        switch (layoutType) {
            case LINEAR_VERTICAL:
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                break;
            case LINEAR_HORIZONTAL:
                recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                break;
            case GRID:
                // TODO
                break;
        }

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.setNestedScrollingEnabled(false);

    }
}
