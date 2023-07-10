package com.example.projectstddb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Std_add extends AppCompatActivity {

    EditText eroll,ename,emob,eadrs,ebranch;
   static int cnt=0;

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
    protected void onDestroy(){
        super.onDestroy();
        cnt=0;
        finish();
    }

    public void store(View view) {
        boolean add=false,flag=false;
        if(!eroll.getText().toString().matches("[A-Za-z0-9]+")) {
            eroll.setError("Please Enter valid Roll no");
            add=false;
        }
        if(!ename.getText().toString().matches("[a-zA-Z /s]+")) {
            ename.setError("Please Enter valid name");
            add=false;
        }
        if(!eadrs.getText().toString().matches("[a-zA-Z/: /s]+")) {
            eadrs.setError("Please Enter valid address");
            add=false;
        }
      
        if(!ebranch.getText().toString().matches("[a-zA-Z]+")) {
            ebranch.setError("Please Enter valid branch");
            add=false;
        }
        else{
            add=true;
            for (int i=0 ; i<Std_data.std_collection.size();i++){
                if(eroll.getText().toString().equals(Std_data.std_collection.get(i).getRoll())){
                    add=false;
                }
            }
            if (add==false){
                eroll.setError("Roll No. already exists");
            }
        }
        if(eroll.getText().toString().isEmpty()) {
            eroll.setError("Please Enter rollno");
            add=add&false;
        }
        else{
            add=add&true;
        }
        if(ename.getText().toString().isEmpty()) {
            ename.setError("Please Enter name");
            add=add&false;
        }
        else{
            add=add&true;
        }
        if(emob.getText().toString().length()!=10)
        {
            flag=true;
            emob.setError("mobile number size should be 10");
        }
        if(emob.getText().toString().isEmpty()) {
            emob.setError("Please Enter mobile no");
            add=add&false;
        }
        else{
            add=add&true;
        }
        if(eadrs.getText().toString().isEmpty()) {
            eadrs.setError("Please Enter address");
            add=add&false;
        }
        else{
            add=add&true;
        }
        if(ebranch.getText().toString().isEmpty()) {
            ebranch.setError("Please Enter branch");
            add=add&false;
        }
        else{
            add=add&true;
        }
        if(add==true ) {

            if(flag==false && cnt==0) {
                cnt++;
                Std_data.db.execSQL("INSERT INTO stud VALUES (" + eroll.getText().toString() + ",'" + ename.getText().toString() + "','" + emob.getText().toString() + "','" + eadrs.getText().toString() + "','" + ebranch.getText().toString() + "')");
                    Toast.makeText(getApplicationContext(), "Student record inserted", Toast.LENGTH_LONG).show();
            }
        }

    }
}