package com.example.projectstddb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

public class Std_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_home);

        Std_data.db= openOrCreateDatabase(Std_data.dbname,MODE_PRIVATE,null);
        Std_data.db.execSQL("CREATE TABLE IF NOT EXISTS stud(roll number(5),name varchar(200),mob varchar(11), addrs varchar(200), branch varchar(200))");
        fetchData();
    }

    public static void fetchData()
    {
        Cursor stddata=Std_data.db.rawQuery("SELECT * FROM stud",null);
        Std_data.std_collection.clear();

        while (stddata.moveToNext())
        {
            Std_data info=new Std_data();
            info.setRoll(stddata.getString(0));
            info.setName(stddata.getString(1));
            info.setMobile(stddata.getString(2));
            info.setAddr(stddata.getString(3));
            info.setBranch(stddata.getString(4));
            Std_data.std_collection.add(info);
        }


    }

    public void add(View view) {
        Intent add=new Intent(getApplicationContext(),Std_add.class);
        startActivity(add);
    }

    public void delete(View view) {

        Intent delete=new Intent(getApplicationContext(),Std_delete.class);
        delete.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(delete);
    }

    public void update(View view) {
        Intent update=new Intent(getApplicationContext(),Std_update.class);
        startActivity(update);
    }

    public void show(View view) {
        Intent show=new Intent(getApplicationContext(),Std_show.class);
        show.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        int i=0;
        show.putExtra("show",""+i);

        startActivity(show);
    }

    public void showAll(View view) {
        Intent show=new Intent(getApplicationContext(),Std_showAll.class);
        startActivity(show);
    }
}