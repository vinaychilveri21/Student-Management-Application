package com.example.projectstddb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Std_update extends AppCompatActivity {

    EditText eroll,ename,emob,eadrs,ebranch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_update);
        eroll=findViewById(R.id.edt_roll);
        ename=findViewById(R.id.edt_name);
        emob=findViewById(R.id.edt_mob);
        eadrs=findViewById(R.id.edt_adrs);
        ebranch=findViewById(R.id.edt_branch);

        Std_home.fetchData();


    }

    public void updateName(View view) {
        boolean up=false,flag=false;

        if(eroll.getText().toString().isEmpty())
        {
            eroll.setError("please enter roll no");
            ename.setError("Please enter name");
        }
        else if(!eroll.getText().toString().matches("[0-9A-Za-z]+"))
        {
            ename.setError("Please enter name");
            eroll.setError("please enter valid roll no");
        }
        else {
            for (int i = 0; i < Std_data.std_collection.size(); i++) {
                if (eroll.getText().toString().equals(Std_data.std_collection.get(i).getRoll())) {
                    up = true;
                }
            }
            if (up == true) {
                String str = ename.getText().toString();
                if(str.isEmpty())
                {
                    ename.setError("Please enter name");
                }
                else if(!str.matches("[A-Za-z /s]+"))
                {
                    ename.setError("please enter valid name");
                }
                else {
                    Std_data.db.execSQL("UPDATE stud SET name='" + ename.getText().toString() + "' WHERE roll=" + eroll.getText().toString());
                    Toast.makeText(getApplicationContext(), "name updated successfully", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Roll no. not found", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void updateMob(View view) {
        boolean up=false,flag=false;

        if(eroll.getText().toString().isEmpty())
        {
            eroll.setError("please enter roll no");
            emob.setError("Please enter mobile no");
        }
        else if(!eroll.getText().toString().matches("[0-9A-Za-z]+"))
        {
            emob.setError("Please enter valid mobile no");
            eroll.setError("please enter valid roll no");
        }
        else {
            for (int i = 0; i < Std_data.std_collection.size(); i++) {
                if (eroll.getText().toString().equals(Std_data.std_collection.get(i).getRoll())) {
                    up = true;
                }
            }
            if (up == true) {
                String str = emob.getText().toString();
                if(str.isEmpty())
                {
                    emob.setError("Please enter mobile no");
                }
                else if(!str.matches("[0-9]+"))
                {
                    emob.setError("Please enter valid mobile no");
                }
                else if(str.length()==10){
                    Std_data.db.execSQL("UPDATE stud SET mob='" + emob.getText().toString() + "' WHERE roll=" + eroll.getText().toString());
                    Toast.makeText(getApplicationContext(), "Mobile no updated successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    emob.setError("Enter 10 digit mobile no");
                }
            } else {
                Toast.makeText(getApplicationContext(), "Roll no. not found", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void updateAdrs(View view) {
        boolean up=false,flag=false;

        if(eroll.getText().toString().isEmpty())
        {
            eroll.setError("please enter roll no");
            eadrs.setError("Please enter address");
        }
        else if(!eroll.getText().toString().matches("[0-9A-Za-z]+"))
        {
            eadrs.setError("Please enter valid address");
            eroll.setError("please enter valid roll no");
        }
        else {
            for (int i = 0; i < Std_data.std_collection.size(); i++) {
                if (eroll.getText().toString().equals(Std_data.std_collection.get(i).getRoll())) {
                    up = true;
                }
            }
            if (up == true) {
                String str = eadrs.getText().toString();
                if(str.isEmpty())
                {
                    eadrs.setError("Please enter address");
                }
                else if(!str.matches("[0-9A-Za-z /s]+"))
                {
                    eadrs.setError("Please enter valid address");
                }
                else{
                    Std_data.db.execSQL("UPDATE stud SET addrs='" + eadrs.getText().toString() + "' WHERE roll=" + eroll.getText().toString());
                    Toast.makeText(getApplicationContext(), "Address updated successfully", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Roll no. not found", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void updateBranch(View view) {
        boolean up=false,flag=false;

        if(eroll.getText().toString().isEmpty())
        {
            eroll.setError("please enter roll no");
            ebranch.setError("Please enter branch");
        }
        else if(!eroll.getText().toString().matches("[0-9A-Za-z]+"))
        {
            ebranch.setError("Please enter valid branch");
            eroll.setError("please enter valid roll no");
        }
        else {
            for (int i = 0; i < Std_data.std_collection.size(); i++) {
                if (eroll.getText().toString().equals(Std_data.std_collection.get(i).getRoll())) {
                    up = true;
                }
            }
            if (up == true) {
                String str = ebranch.getText().toString();
                if(str.isEmpty())
                {
                    ebranch.setError("Please enter branch");
                }
                else if(!str.toString().matches("[a-zA-Z]+"))
                {
                    ebranch.setError("Please enter valid branch");
                }
                else{
                    Std_data.db.execSQL("UPDATE stud SET branch='" + ebranch.getText().toString() + "' WHERE roll=" + eroll.getText().toString());
                    Toast.makeText(getApplicationContext(), "Branch updated successfully", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Roll no. not found", Toast.LENGTH_SHORT).show();
            }
        }
    }

}