package com.example.projectstddatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class Std_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std__home);

        Std_info.db= openOrCreateDatabase(Std_info.dbname,MODE_PRIVATE,null);
        Std_info.db.execSQL("CREATE TABLE IF NOT EXISTS stud(roll number(5),name varchar(200),mob varchar(11), addrs varchar(200), branch varchar(200))");

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
        Intent show=new Intent(getApplicationContext(),Std_showall.class);
        show.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        int i=0;
        show.putExtra("showall",""+i);

        startActivity(show);
    }
}