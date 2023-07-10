package com.example.projectstddatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Std_add extends AppCompatActivity {

    EditText eroll,ename,emob,eadrs,ebranch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_add);
        eroll=findViewById(R.id.edt_roll);
        ename=findViewById(R.id.edt_name);
        emob=findViewById(R.id.edt_mob);
        eadrs=findViewById(R.id.edt_adrs);
        ebranch=findViewById(R.id.edt_branch);
    }

    public void store(View view) {
        boolean add=false;
        if(eroll.getText().toString().isEmpty()) {
            eroll.setError("Please Enter Roll no");
            add=false;
        }
        else{
            add=true;
            for (int i=0 ; i<Std_info.std_collection.size();i++){
                if(eroll.getText().toString().equals(Std_info.std_collection.get(i).getRoll())){
                    add=false;
                }
            }
            if (add==false){
                eroll.setError("Roll No. already exists");
            }
        }
        if(ename.getText().toString().isEmpty()) {
            ename.setError("Please Enter name");
            add=add&false;
        }
        else{
            add=add&true;
        }
        if(add==true) {
            Std_info.db.execSQL("INSERT INTO stud VALUES (" + eroll.getText().toString() + ",'" + ename.getText().toString() + "','" + emob.getText().toString() + "','" + eadrs.getText().toString() + "','" + ebranch.getText().toString() + "')");
            Toast.makeText(getApplicationContext(), "Student record inserted", Toast.LENGTH_LONG).show();
        }
    }
}