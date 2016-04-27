package com.example.dawid.lan;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Dawid on 2015-08-27.
 */
public class FragmentA extends Fragment {

    private MyDBHandler dbHandler;
    private Button name1;
    private Button name2;
    private Button name3;
    private Button name4;
    private Button name5;

    private PackageManager manager;

    public FragmentA() {
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dbHandler = new MyDBHandler(getActivity(), null, null, 1);

        View view =inflater.inflate(R.layout.fragment_a, container , false);


        name1=(Button)view.findViewById(R.id.S1);
        name2=(Button)view.findViewById(R.id.S2);
        name3=(Button)view.findViewById(R.id.S3);
        name4=(Button)view.findViewById(R.id.S4);
        name5=(Button)view.findViewById(R.id.S5);

        reloadData();

        return view;

    }


    @Override
    public void onResume() {
        super.onResume();
        reloadData();

    }

    public void reloadData(){
        name1.setText(dbHandler.databaseToString(1));
        name2.setText(dbHandler.databaseToString(3));
        name3.setText(dbHandler.databaseToString(5));
        name4.setText(dbHandler.databaseToString(7));
        name5.setText(dbHandler.databaseToString(9));

    }
}
