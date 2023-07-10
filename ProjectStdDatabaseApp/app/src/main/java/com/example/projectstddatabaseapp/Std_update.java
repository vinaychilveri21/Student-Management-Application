package com.example.projectstddatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Std_update extends AppCompatActivity {
    EditText eroll,ename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_update);
        eroll=findViewById(R.id.edt_roll);
        ename=findViewById(R.id.edt_name);
    }

    public void updateName(View view) {
        boolean up=false;
        for (int i=0 ; i<Std_info.std_collection.size();i++){
            if(eroll.getText().toString().equals(Std_info.std_collection.get(i).getRoll())){
                up=true;
            }
        }
        if(up==true) {
            Std_info.db.execSQL("UPDATE stud SET name='"+ename.getText().toString()+"' WHERE roll=''"+eroll.getText().toString()+"'");
            Toast.makeText(getApplicationContext(), "Record updated successfully", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Roll no. not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateMob(View view) {
    }

    public void updateAdrs(View view) {
    }

    public void updateBranch(View view) {
    }
}