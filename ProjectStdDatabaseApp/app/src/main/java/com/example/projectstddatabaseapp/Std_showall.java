package com.example.projectstddatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class Std_showall extends AppCompatActivity {

    TextView troll,tname,tmob,tadrs,tbranch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_showall);
        troll=findViewById(R.id.txt_roll);
        tname=findViewById(R.id.txt_name);
        tmob=findViewById(R.id.txt_mob);
        tadrs=findViewById(R.id.txt_adrs);
        tbranch=findViewById(R.id.txt_branch);

        Cursor stddata=Std_info.db.rawQuery("SELECT * FROM stud",null);
        Std_info.std_collection.clear();

        while (stddata.moveToNext())
        {
            Std_info info=new Std_info();
            info.setRoll(stddata.getString(0));
            info.setName(stddata.getString(1));
            info.setMobile(stddata.getString(2));
            info.setAddr(stddata.getString(3));
            info.setBranch(stddata.getString(4));
            Std_info.std_collection.add(info);
        }

        Intent showall=getIntent();
        int i=Integer.parseInt(showall.getStringExtra("showall"));
        troll.setText("RollNo="+Std_info.std_collection.get(i).getRoll());
        tname.setText("Name="+Std_info.std_collection.get(i).getName());
        tmob.setText("Mobile="+Std_info.std_collection.get(i).getMobile());
        tadrs.setText("Address="+Std_info.std_collection.get(i).getAddr());
        tbranch.setText("Branch="+Std_info.std_collection.get(i).getBranch());

    }
}