package com.example.dawid.lan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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
        TextView nameSettings =(TextView)findViewById(R.id.nameSettings);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("NAME");
            label = extras.getString("LABEL");
        }

        nameSettings.setText(label);

        name1=(Button)findViewById(R.id.ST1);
        name2=(Button)findViewById(R.id.ST2);
        name3=(Button)findViewById(R.id.ST3);
        name4=(Button)findViewById(R.id.ST4);
        name5=(Button)findViewById(R.id.ST5);

        name1.setText(dbHandler.databaseToString(1));
        name2.setText(dbHandler.databaseToString(3));
        name3.setText(dbHandler.databaseToString(5));
        name4.setText(dbHandler.databaseToString(7));
        name5.setText(dbHandler.databaseToString(9));


    }




}
