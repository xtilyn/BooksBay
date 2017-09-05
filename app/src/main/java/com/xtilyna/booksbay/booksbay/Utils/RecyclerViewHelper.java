package com.xtilyna.booksbay.booksbay.Utils;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class RecyclerViewHelper {

    public final static int linearVertical = 0;
    public final static int linearHorizontal = 1;
    public final static int grid = 2;

    public static void setupRecyclerView(
            Context context,
            RecyclerView recyclerView,
            int layoutType,
            RecyclerView.Adapter adapter,
            List data) {

        recyclerView.setAdapter(adapter);
        switch (layoutType) {
            case linearVertical:
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                break;
            case linearHorizontal:
                recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                break;
            case grid:
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
