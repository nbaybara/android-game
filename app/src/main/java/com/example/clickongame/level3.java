package com.example.clickongame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class level3 extends AppCompatActivity {

    int score;
    TextView scoreText;
    TextView timeText;

    ImageView ımageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        final String username = getIntent().getStringExtra("USERNAME");

        timeText=findViewById(R.id.timeText);
        scoreText=findViewById(R.id.scoreText);
        ımageView1 =findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4 =findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);
        imageView6 =findViewById(R.id.imageView6);
        imageView7=findViewById(R.id.imageView7);
        imageView8=findViewById(R.id.imageView8);
        imageView9 =findViewById(R.id.imageView9);

        //İmageleri diziye atadım.
        imageArray= new ImageView[]{ımageView1,imageView2,imageView3, imageView4,imageView5, imageView6,imageView7,imageView8, imageView9};
        hideImages();
        score=0;

        new CountDownTimer(10000,1000){
            //Oyundaki süre kısmı
            public void onTick(long millisUntilFinished) {
                timeText.setText("Son: " + millisUntilFinished/ 1000+"sn var" );
                //10 Saniye tanımladık.
            }

            @Override
            public void onFinish() {
                if(score > 10) {
                    timeText.setText("Vay canına!!"+ username+" Çok sinir olmuş olmalısın.Neredeyse ekran kırılacaktı!");
                }
                else{
                    timeText.setText("Sinirden ellerin tutmuyor olmalı " + username);

                }
                handler.removeCallbacks(runnable); //Durdurmaya yarıyor

                for(ImageView image: imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                //oyun bittiği için mesajı yazdırıyoruz.
                AlertDialog.Builder  alert = new AlertDialog.Builder(level3.this);
                alert.setTitle("Ufaklık yeterince hırpalandı");
                alert.setMessage("Biraz daha sinirlerini gevşetmek ister misin?");
                alert.setPositiveButton("Gönder Gelsin", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Evet dediğimiz için oyun baştan başlayacak
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);//kEndi activtymizi baştan başlatıyoruz
                    }
                });
                alert.setNegativeButton("Kendimi yormaya değmez", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(level3.this,"İşimiz bitti",Toast.LENGTH_SHORT).show();
                        Intent exitMenu = new Intent(level3.this,menuPage.class);
                        startActivity(exitMenu);
                    }
                });
                alert.show();

            }
        }.start();

    }
    public void scoreUp(View view) {
        score++;
        scoreText.setText("Score : " + score);
    }
    public void hideImages(){
        handler=new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                    //Resimleri görünmez yaptık
                }
                Random random = new Random();
                int i= random.nextInt(9);
                //0 ve 8 arasında rastgele sayı oluşturacak
                imageArray[i].setVisibility(View.VISIBLE); //rastgele bir resim visible oldu
                handler.postDelayed(this,400);
            }
        };
        handler.post(runnable);
    }
}
