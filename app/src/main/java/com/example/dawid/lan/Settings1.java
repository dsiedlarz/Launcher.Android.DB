package com.example.dawid.lan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Settings1 extends AppCompatActivity {

    private String name;
    private String label;
    private Button name1;
    private Button name2;
    private Button name3;
    private Button name4;
    private Button name5;
    private MyDBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings1);
        TextView nameSettings = (TextView) findViewById(R.id.nameSettings);

        dbHandler = new MyDBHandler(this, null, null, 1);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("NAME");
            label = extras.getString("LABEL");
            nameSettings.setText(label);
        }

        ///   Toast.makeText(this, dbHandler.databaseToString(1), Toast.LENGTH_LONG).show();

        name1 = (Button) findViewById(R.id.ST1);
        name2 = (Button) findViewById(R.id.ST2);
        name3 = (Button) findViewById(R.id.ST3);
        name4 = (Button) findViewById(R.id.ST4);
        name5 = (Button) findViewById(R.id.ST5);


        name1.setText(dbHandler.databaseToString(1));
        name2.setText(dbHandler.databaseToString(3));
        name3.setText(dbHandler.databaseToString(5));
        name4.setText(dbHandler.databaseToString(7));
        name5.setText(dbHandler.databaseToString(9));


    }


    public void Sett1(View view){
        dbHandler.deleteProduct(1);
        dbHandler.deleteProduct(2);
        dbHandler.addProduct(new Product(1, label));
        dbHandler.addProduct(new Product(2, name));
        Toast.makeText(this, "Zakończono powodzeniem", Toast.LENGTH_LONG).show();
        finish();
    }
    public void Sett2(View view){
        dbHandler.deleteProduct(3);
        dbHandler.deleteProduct(4);
        dbHandler.addProduct(new Product(3, label));
        dbHandler.addProduct(new Product(4, name));
        Toast.makeText(this, "Zakończono powodzeniem", Toast.LENGTH_LONG).show();
        finish();
    }
    public void Sett3(View view){
        dbHandler.deleteProduct(5);
        dbHandler.deleteProduct(6);
        dbHandler.addProduct(new Product(5, label));
        dbHandler.addProduct(new Product(6, name));
        Toast.makeText(this, "Zakończono powodzeniem", Toast.LENGTH_LONG).show();
        finish();
    }
    public void Sett4(View view){
        dbHandler.deleteProduct(7);
        dbHandler.deleteProduct(8);
        dbHandler.addProduct(new Product(7, label));
        dbHandler.addProduct(new Product(8, name));
        Toast.makeText(this, "Zakończono powodzeniem", Toast.LENGTH_LONG).show();
        finish();
    }
    public void Sett5(View view){
        dbHandler.deleteProduct(9);
        dbHandler.deleteProduct(10);
        dbHandler.addProduct(new Product(9, label));
        dbHandler.addProduct(new Product(10, name));
        Toast.makeText(this, "Zakończono powodzeniem", Toast.LENGTH_LONG).show();
        finish();
    }


}
