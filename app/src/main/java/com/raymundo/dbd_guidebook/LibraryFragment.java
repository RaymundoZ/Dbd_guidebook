package com.raymundo.dbd_guidebook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.raymundo.dbd_guidebook.models.Item;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends InfoFragment {

    private static final String TAG = "com.raymundo.dbd_guidebook.LibraryFragment";

    public static LibraryFragment newInstance() {

        Bundle args = new Bundle();

        LibraryFragment fragment = new LibraryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View loadView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_layout, container, false);
        return view;
    }

    @Override
    public List<Item> loadItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Выжившие", R.drawable.icon_survivor));
        items.add(new Item("Убийцы", R.drawable.icon_killer));
        items.add(new Item("Умения", R.drawable.icon_perk));
        return items;
    }

    public static String getTAG() {
        return TAG;
    }
}
