package com.example.projectstddb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Std_delete extends AppCompatActivity {

    EditText eroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_delete);
        eroll=findViewById(R.id.edt_roll);
    }

    public void delete(View view) {

        boolean found=false,flag=true;

        if(!eroll.getText().toString().matches("[a-zA-Z0-9]+"))
        {
            eroll.setError("please enter valid roll no");
            flag=false;

        }


        if(eroll.getText().toString().isEmpty())
        {
            eroll.setError("Please enter roll no");



        }

        else
        {
            for (int i=0 ; i<Std_data.std_collection.size();i++){

                if(eroll.getText().toString().equals(Std_data.std_collection.get(i).getRoll())){
                    found=true;


                }
            }

            if(flag==true) {

                if (found) {
                    Std_data.db.execSQL("DELETE FROM stud WHERE roll=" + eroll.getText().toString());
                    Toast.makeText(getApplicationContext(), "Record deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Roll no. not found", Toast.LENGTH_SHORT).show();
                }
            }
        }


    }
}