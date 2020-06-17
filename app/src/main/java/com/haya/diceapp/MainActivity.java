package com.haya.diceapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView Dice_1 = findViewById(R.id.diceImage1);
        final ImageView Dice_2 = findViewById(R.id.diceImage2);

        final int [] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6,};

        Button roll_Dice_btn = findViewById(R.id.rollDice);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.dice_sound);

        roll_Dice_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Random random = new Random();
            int myRandomNumber = random.nextInt(6);
            Dice_1.setImageResource(diceImages[myRandomNumber]);

            myRandomNumber = random.nextInt(6);
            Dice_2.setImageResource(diceImages[myRandomNumber]);

            YoYo.with(Techniques.Tada)
                    .duration(500)
                    .repeat(0)
                    .playOn(Dice_1);


            YoYo.with(Techniques.Tada)
                    .duration(500)
                    .repeat(0)
                    .playOn(Dice_2);

            mp.start();

            }
        });
    }
}