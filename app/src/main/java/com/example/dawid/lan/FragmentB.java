package com.example.dawid.lan;

import com.example.dawid.lan.MainActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dawid on 2015-08-27.
 */
public class FragmentB extends ListFragment {
    private PackageManager manager;
    private LayoutInflater layoutInflater;


    public FragmentB() {
    }

    public FragmentB (PackageManager manager) {
        this.manager = manager;

        loadApps();

        //loadListView();
        //addClickListener();


    }


    private static final String TAG = "MyActivity";

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

           @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
             Toast.makeText(getActivity(), "On long click listener " +arg2+" "+arg3, Toast.LENGTH_LONG).show();
               Intent i = new Intent(getContext(), Settings1.class);
               i.putExtra("LABEL",apps.get(arg2).label.toString());
               i.putExtra("NAME",apps.get(arg2).name.toString());
                startActivity(i);
               return true;
                }
        });

                loadListView();
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = manager.getLaunchIntentForPackage(apps.get(position).name.toString());
        startActivity(i);
    }





    /*
    public FragmentB() {

        Log.v(TAG, "FragmentB");
        AppsListActivity l= new AppsListActivity();



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container , false);

    }

*/


    private List<AppDetail> apps;


    private void loadApps() {

        apps = new ArrayList<AppDetail>();

        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> availableActivities = manager.queryIntentActivities(i, 0);
        for (ResolveInfo ri : availableActivities) {
            AppDetail app = new AppDetail();
            app.label = ri.loadLabel(manager);
            app.name = ri.activityInfo.packageName;
            app.icon = ri.activityInfo.loadIcon(manager);
            apps.add(app);
        }
        //sortujemy
        int k = 0, j = 0, l = 0;
        AppDetail tmp1, tmp2;
        for (k = 0; k < apps.size() - 1; k++) {
            tmp1 = apps.get(k);
            tmp2 = apps.get(k + 1);
            l = k + 1;
            for (j = k + 1; j < apps.size(); j++) {
                if (apps.get(j).label.toString().compareToIgnoreCase(tmp2.label.toString()) < 0) {
                    tmp2 = apps.get(j);
                    l = j;
                }

            }
            if (tmp1.label.toString().compareToIgnoreCase(tmp2.label.toString()) > 0) {
                apps.set(k, tmp2);
                apps.set(l, tmp1);

            }
        }
    }









    private void loadListView() {

    Context context= getActivity();
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ArrayAdapter<AppDetail> adapter = new ArrayAdapter<AppDetail>(context,
                R.layout.list_item,
                apps) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = layoutInflater.inflate(R.layout.list_item, null);
                }

                ImageView appIcon = (ImageView) convertView.findViewById(R.id.item_app_icon);
                appIcon.setImageDrawable(apps.get(position).icon);

                TextView appLabel = (TextView) convertView.findViewById(R.id.item_app_label);
                appLabel.setText(apps.get(position).label);

                //TextView appName = (TextView)convertView.findViewById(R.id.item_app_name);
                //appName.setText(apps.get(position).name);

                return convertView;
            }
        };

       setListAdapter(adapter);
    }






}




