package com.example.clickongame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    EditText etLoginUN;
    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginUN=findViewById(R.id.et_LoginUN);
        btnGo=findViewById(R.id.btn_go);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=etLoginUN.getText().toString();
                if(!TextUtils.isEmpty(userName)) {


                    Intent welcomeIntent = new Intent(getApplicationContext(), menuPage.class);
                    welcomeIntent.putExtra("USERNAME", userName);
                    startActivity(welcomeIntent);

                }else
                    Toast.makeText(getApplicationContext(),"Username is empty",Toast.LENGTH_SHORT).show();




            }
        });


    }
}
