package com.example.projectstddb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText euser,epass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        euser=findViewById(R.id.edt_user);
        epass=findViewById(R.id.edt_pass);

    }

    public void login(View view) {
        if(euser.getText().toString().isEmpty())
        {
            euser.setError("please enter username");
        }
        if(epass.getText().toString().isEmpty())
        {
            epass.setError("please enter password");
        }
        else {
            if (euser.getText().toString().equals("Student") && epass.getText().toString().equals("Std@123"))
            {
                Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_SHORT).show();

                Intent home=new Intent(getApplicationContext(),Std_home.class);
                startActivity(home);
            }
            else{
                Toast.makeText(getApplicationContext(),"please enter valid username or password",Toast.LENGTH_SHORT).show();
            }
        }




    }
}