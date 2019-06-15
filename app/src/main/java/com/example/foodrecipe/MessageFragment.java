package com.example.foodrecipe;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment{
    private GridView gridView;
    private Context mContext;
    private ArrayAdapter<String> adapter;
    //private static String[] spacecrafts = {"Cola","Dadlal","Allda","Aladin","Din","Dad"};


    public static MessageFragment newInstance(){
        MessageFragment messageFragment = new MessageFragment();
        return messageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.menu_category, null);
        gridView = (GridView) rootView.findViewById(R.id.grid_view);
        //GridView gridView = (GridView) findViewById(R.id.grid_view);
        final MenuAdapter menuAdapter = new MenuAdapter(getActivity(), photos);
        gridView.setAdapter(menuAdapter);
        //gridView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, spacecrafts));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Menu menu = photos[position];
               // Toast.makeText(getActivity(), "Your Message", Toast.LENGTH_SHORT).show();

                android.support.v4.app.Fragment MenuDetailActivity = new MenuDetailActivity();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.containerID, MenuDetailActivity).commit();
                //MessageFragment.this.().beginTransaction().replace(R.id.containerID,MessageFragment.newInstance()).commit();

            }


        });

        return rootView;

    }


    @Override
    public String toString() {
        return "MessageFragment";
    }

    private Menu[] photos= {
            new Menu("Bee",R.drawable.beefe),
            new Menu("Chicken",R.drawable.chick),
    };
}

