package com.example.projectstddatabaseapp;

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
        boolean del=false;
        for (int i=0 ; i<Std_info.std_collection.size();i++){
            if(eroll.getText().toString().equals(Std_info.std_collection.get(i).getRoll())){
                del=true;
            }
        }
        if(del==true) {
            Std_info.db.execSQL("DELETE FROM stud WHERE roll=" + eroll.getText().toString());
            Toast.makeText(getApplicationContext(), "Record deleted successfully", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Roll no. not found", Toast.LENGTH_SHORT).show();
        }
    }
}