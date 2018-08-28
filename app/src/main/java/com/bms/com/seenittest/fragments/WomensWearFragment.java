package com.bms.com.seenittest.fragments;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bms.com.seenittest.R;
import com.bms.com.seenittest.adapters.ItemListAdapter;
import com.bms.com.seenittest.model.ItemsModel;

import java.util.ArrayList;
import java.util.List;

public class WomensWearFragment extends Fragment
{
    private RecyclerView rvItemList;
    private ItemListAdapter adapter;
    private List<ItemsModel> itemsModelList;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.womens_wear_ftagment_layout, container, false);
        initViews();
        setViwes();
        return view;
    }

    private void setViwes()
    {
        itemsModelList = new ArrayList<>();
        adapter = new ItemListAdapter(getActivity(), itemsModelList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        rvItemList.setLayoutManager(mLayoutManager);
        rvItemList.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        rvItemList.setItemAnimator(new DefaultItemAnimator());
        rvItemList.setAdapter(adapter);

        prepareItemsList();

    }

    private void initViews()
    {
        rvItemList = view.findViewById(R.id.rvItemList);

    }

    /**
     * Adding few albums for testing
     */
    private void prepareItemsList()
    {
        int[] covers = new int[]{
                R.drawable.item,
                R.drawable.item,
                R.drawable.item,
                R.drawable.item,
                R.drawable.item,
                R.drawable.item,
                R.drawable.item,
                R.drawable.item,
                R.drawable.item,
                R.drawable.item,
                R.drawable.item,
                R.drawable.item,
                R.drawable.item,
                R.drawable.item};

        ItemsModel itemsModel = new ItemsModel("Harpa Casual", covers[0]);
        itemsModelList.add(itemsModel);
        ItemsModel itemsModel1 = new ItemsModel("Harpa Casual", covers[1]);
        itemsModelList.add(itemsModel1);
        ItemsModel itemsMode2 = new ItemsModel("Harpa Casual", covers[2]);
        itemsModelList.add(itemsMode2);
        ItemsModel itemsMode3 = new ItemsModel("Harpa Casual", covers[3]);
        itemsModelList.add(itemsMode3);
        ItemsModel itemsMode4 = new ItemsModel("Harpa Casual", covers[4]);
        itemsModelList.add(itemsMode4);
        ItemsModel itemsMode5 = new ItemsModel("Harpa Casual", covers[5]);
        itemsModelList.add(itemsMode5);
        ItemsModel itemsMode6 = new ItemsModel("Harpa Casual", covers[6]);
        itemsModelList.add(itemsMode6);
        ItemsModel itemsMode7 = new ItemsModel("Harpa Casual", covers[7]);
        itemsModelList.add(itemsMode7);
        ItemsModel itemsMode8 = new ItemsModel("Harpa Casual", covers[8]);
        itemsModelList.add(itemsMode8);
        ItemsModel itemsMode9 = new ItemsModel("Harpa Casual", covers[9]);
        itemsModelList.add(itemsMode9);
        ItemsModel itemsModel0 = new ItemsModel("Harpa Casual", covers[10]);
        itemsModelList.add(itemsModel0);
        ItemsModel itemsModel12 = new ItemsModel("Harpa Casual", covers[11]);
        itemsModelList.add(itemsModel12);
        ItemsModel itemsModel2 = new ItemsModel("Harpa Casual", covers[12]);
        itemsModelList.add(itemsModel2);
        ItemsModel itemsModel3 = new ItemsModel("Harpa Casual", covers[13]);
        itemsModelList.add(itemsModel3);


        adapter.notifyDataSetChanged();
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp)
    {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration
    {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge)
        {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state)
        {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge)
            {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount)
                { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else
            {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount)
                {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

}
