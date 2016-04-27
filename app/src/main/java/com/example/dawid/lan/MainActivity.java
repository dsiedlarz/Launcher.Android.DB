package com.example.dawid.lan;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    private MyDBHandler dbHandler;
    private String Set2;
    private String Set4;
    private String Set6;
    private String Set8;
    private String Set10;

    private PackageManager menager;

    ViewPager viewPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menager = getPackageManager();
        viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        MyAdapter myAdapter = new MyAdapter(fragmentManager);
        myAdapter.setManager(menager);
        viewPager.setAdapter(myAdapter);
        dbHandler = new MyDBHandler(this, null, null, 1);
        if(dbHandler.databaseToString(1).compareToIgnoreCase("problem")==0){
            dbHandler.addProduct(new Product(1,"Telefon"));
            dbHandler.addProduct(new Product(2,"com.android.dialer"));
            dbHandler.addProduct(new Product(3,"SMS"));
            dbHandler.addProduct(new Product(4,"com.android.mms"));
            dbHandler.addProduct(new Product(5,"Internet"));
            dbHandler.addProduct(new Product(6,"com.android.browser"));
            dbHandler.addProduct(new Product(7,"Muzyka"));
            dbHandler.addProduct(new Product(8,"com.andrew.apollo"));
            dbHandler.addProduct(new Product(9,"Aparat"));
            dbHandler.addProduct(new Product(10,"com.android.camera2"));
        }
        Set2=dbHandler.databaseToString(2);
        Set4=dbHandler.databaseToString(4);
        Set6=dbHandler.databaseToString(6);
        Set8=dbHandler.databaseToString(8);
        Set10=dbHandler.databaseToString(10);



        //Toast.makeText(this,dbHandler.databaseToString(1),Toast.LENGTH_LONG).show();
    }

    public void short1(View view){
        Intent i = menager.getLaunchIntentForPackage( Set8);
        startActivity(i);
    }
    public void short2(View view){
        Intent i = menager.getLaunchIntentForPackage(Set2);
        startActivity(i);
    }
    public void short3(View view){
        Intent i = menager.getLaunchIntentForPackage(Set4);
        startActivity(i);
    }
    public void short4(View view){
        Intent i = menager.getLaunchIntentForPackage(Set6);
        startActivity(i);
    }
    public void short5(View view){
        Intent i = menager.getLaunchIntentForPackage(Set10);
        startActivity(i);
    }


}




class MyAdapter extends FragmentPagerAdapter {

    private PackageManager manager;
    private LayoutInflater layoutInflater;


    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setManager(PackageManager manager) {
        this.manager = manager;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment= null;
        if(position==0){
            fragment = new FragmentA();
        }
        if(position==1){
            fragment =(Fragment) new FragmentB(manager);
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}