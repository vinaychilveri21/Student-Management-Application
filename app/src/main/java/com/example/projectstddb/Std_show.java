package com.example.projectstddb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Std_show extends AppCompatActivity {

    EditText eroll;
    TextView troll,tname,tmob,tadrs,tbranch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_show);
        eroll=findViewById(R.id.edt_roll);
        troll=findViewById(R.id.txt_roll);
        tname=findViewById(R.id.txt_name);
        tmob=findViewById(R.id.txt_mob);
        tadrs=findViewById(R.id.txt_adrs);
        tbranch=findViewById(R.id.txt_branch);


    }

    public void show(View view) {
        Std_home.fetchData();

        boolean del = false,flag=false;

        if (eroll.getText().toString().isEmpty()) {
            eroll.setError("please enter roll");
        }
        else if(!eroll.getText().toString().matches("[0-9a-zA-Z]+"))
        {
            eroll.setError("please enter valid roll no");
        }

        else {
            for (int i = 0; i < Std_data.std_collection.size(); i++) {
                if (eroll.getText().toString().equals(Std_data.std_collection.get(i).getRoll())) {
                    del = true;
                }
            }
            if (del == true) {
                Cursor stddata = Std_data.db.rawQuery("SELECT * FROM stud WHERE roll=" + eroll.getText().toString(), null);
                Std_data.std_collection.clear();

                while (stddata.moveToNext()) {
                    Std_data info = new Std_data();
                    info.setRoll(stddata.getString(0));
                    info.setName(stddata.getString(1));
                    info.setMobile(stddata.getString(2));
                    info.setAddr(stddata.getString(3));
                    info.setBranch(stddata.getString(4));
                    Std_data.std_collection.add(info);
                }

                Intent show = getIntent();
                int i = Integer.parseInt(show.getStringExtra("show"));

                troll.setText("RollNo=" + Std_data.std_collection.get(i).getRoll());
                tname.setText("Name=" + Std_data.std_collection.get(i).getName());
                tmob.setText("Mobile=" + Std_data.std_collection.get(i).getMobile());
                tadrs.setText("Address=" + Std_data.std_collection.get(i).getAddr());
                tbranch.setText("Branch=" + Std_data.std_collection.get(i).getBranch());

            } else {
                troll.setText("");
                tname.setText("");
                tmob.setText("");
                tadrs.setText("");
                tbranch.setText("");
                if(flag==false)
                    Toast.makeText(this, "Roll not found",Toast.LENGTH_SHORT).show();
            }
        }
    }
}