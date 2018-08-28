package com.bms.com.seenittest.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bms.com.seenittest.R;

public class FineJewelleryFragment extends Fragment
{
    private View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.womens_wear_ftagment_layout, container, false);
        return rootView;
    }

}
