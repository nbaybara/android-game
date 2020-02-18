package com.example.clickongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuPage extends AppCompatActivity {

    Button level1, level2, level3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);
        final String username = getIntent().getStringExtra("USERNAME");


        level1=findViewById(R.id.level1);
        level2=findViewById(R.id.level2);  //Butonları tanımladık
        level3=findViewById(R.id.level3);

        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goLevel1 = new Intent(menuPage.this,MainActivity.class);
                goLevel1.putExtra("USERNAME" , username);
                startActivity(goLevel1);
            }
        });
        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goLevel2 = new Intent(menuPage.this,level2nd.class);
                goLevel2.putExtra("USERNAME" , username);
                startActivity(goLevel2);
            }
        });
        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goLevel3 = new Intent(menuPage.this,level3.class);
                goLevel3.putExtra("USERNAME" , username);
                startActivity(goLevel3);
            }
        });


    }
}
