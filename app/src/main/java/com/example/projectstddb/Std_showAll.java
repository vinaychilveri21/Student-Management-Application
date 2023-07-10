package com.example.projectstddb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class Std_showAll extends AppCompatActivity {

    ListView std_lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int count=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_show_all);
        std_lst=findViewById(R.id.std_lst);


        Cursor stddata=Std_data.db.rawQuery("SELECT * FROM stud",null);
        Std_data.std_collection.clear();


        while (stddata.moveToNext())
        {
            count++;
            Std_data info=new Std_data();
            info.setRoll(stddata.getString(0));
            info.setName(stddata.getString(1));
            info.setMobile(stddata.getString(2));
            info.setAddr(stddata.getString(3));
            info.setBranch(stddata.getString(4));
            Std_data.std_collection.add(info);
        }

        Std_adapter adapter=new Std_adapter(getApplicationContext());
        std_lst.setAdapter(adapter);

        if(count==0)
            Toast.makeText(this, "No records in table", Toast.LENGTH_SHORT).show();

    }
}