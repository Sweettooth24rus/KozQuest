package com.example.kozquest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityone);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        button1 = findViewById(R.id.button1);

        ActivityTwo.currentSituation = ActivityTwo.story.situations.get(ActivityTwo.nameCurrentSituation);
        if (ActivityTwo.nameCurrentSituation.equals("start")) {
            ActivityTwo.player.health = 150;
            ActivityTwo.player.damage = (int) (Math.random() * 9) + 6;
            ActivityTwo.sworld = true;
        }
        if (ActivityTwo.nameCurrentSituation.equals("random")) {
            if (ActivityTwo.sworld) {
                ActivityTwo.random = (int) (Math.random() * 5);
                switch (ActivityTwo.random) {
                    case 0:
                        ActivityTwo.nameCurrentSituation = "randomOne";
                        break;
                    case 1:
                        ActivityTwo.nameCurrentSituation = "randomTwo";
                        break;
                    case 2:
                        ActivityTwo.nameCurrentSituation = "randomThree";
                        break;
                    case 3:
                        ActivityTwo.nameCurrentSituation = "randomFour";
                        ActivityTwo.sworld = false;
                        break;
                    case 4:
                        ActivityTwo.nameCurrentSituation = "randomFive";
                        break;
                    case 5:
                        ActivityTwo.nameCurrentSituation = "randomSix";
                        break;
                }
            } else {
                ActivityTwo.random = (int) (Math.random() * 4);
                switch (ActivityTwo.random) {
                    case 0:
                        ActivityTwo.nameCurrentSituation = "randomOne";
                        break;
                    case 1:
                        ActivityTwo.nameCurrentSituation = "randomTwo";
                        break;
                    case 2:
                        ActivityTwo.nameCurrentSituation = "randomThree";
                        break;
                    case 3:
                        ActivityTwo.nameCurrentSituation = "randomFive";
                        break;
                    case 4:
                        ActivityTwo.nameCurrentSituation = "randomSix";
                        break;
                }
            }
            ActivityTwo.currentSituation = ActivityTwo.story.situations.get(ActivityTwo.nameCurrentSituation);
        }
        if (ActivityTwo.nameCurrentSituation.equals("randomFour"))
            ActivityTwo.player.damage = 0;
        ActivityTwo.player.health += ActivityTwo.currentSituation.dHealth;
        ActivityTwo.player.damage += ActivityTwo.currentSituation.dDamage;
        if (ActivityTwo.player.health <= 0) {
            ActivityTwo.player.health = 0;
            ActivityTwo.nameCurrentSituation = "death";
            ActivityTwo.currentSituation = ActivityTwo.story.situations.get(ActivityTwo.nameCurrentSituation);
        }
        textView1.setText("Здоровье = " + ActivityTwo.player.health);
        textView2.setText("Урон = " + ActivityTwo.player.damage);
        if (ActivityTwo.nameCurrentSituation.equals("battle")) {
            ActivityTwo.textViewMH.setText("Здоровье монстра = " + ActivityTwo.monster.health);
            ActivityTwo.textViewMD.setText("Урон монстра = " + ActivityTwo.monster.damage);
        } else {
            ActivityTwo.textViewMH.setText("");
            ActivityTwo.textViewMD.setText("");
        }
        textView3.setText(ActivityTwo.currentSituation.text);
        button1.setText(ActivityTwo.currentSituation.Ch1text);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityTwo.nameCurrentSituation = ActivityTwo.currentSituation.choices[0];
                if (ActivityTwo.nameCurrentSituation.equals("start")) {
                    ActivityTwo.player.health = 150;
                    ActivityTwo.player.damage = (int) (Math.random() * 9) + 6;
                    ActivityTwo.sworld = true;
                }
                if (ActivityTwo.nameCurrentSituation.equals("random")) {
                    if (ActivityTwo.sworld) {
                        ActivityTwo.random = (int) (Math.random() * 5);
                        switch (ActivityTwo.random) {
                            case 0:
                                ActivityTwo.nameCurrentSituation = "randomOne";
                                break;
                            case 1:
                                ActivityTwo.nameCurrentSituation = "randomTwo";
                                break;
                            case 2:
                                ActivityTwo.nameCurrentSituation = "randomThree";
                                break;
                            case 3:
                                ActivityTwo.nameCurrentSituation = "randomFour";
                                ActivityTwo.sworld = false;
                                break;
                            case 4:
                                ActivityTwo.nameCurrentSituation = "randomFive";
                                break;
                            case 5:
                                ActivityTwo.nameCurrentSituation = "randomSix";
                                break;
                        }
                    } else {
                        ActivityTwo.random = (int) (Math.random() * 4);
                        switch (ActivityTwo.random) {
                            case 0:
                                ActivityTwo.nameCurrentSituation = "randomOne";
                                break;
                            case 1:
                                ActivityTwo.nameCurrentSituation = "randomTwo";
                                break;
                            case 2:
                                ActivityTwo.nameCurrentSituation = "randomThree";
                                break;
                            case 3:
                                ActivityTwo.nameCurrentSituation = "randomFive";
                                break;
                            case 4:
                                ActivityTwo.nameCurrentSituation = "randomSix";
                                break;
                        }
                    }
                    ActivityTwo.currentSituation = ActivityTwo.story.situations.get(ActivityTwo.nameCurrentSituation);
                }
                if (ActivityTwo.nameCurrentSituation.equals("randomFour"))
                    ActivityTwo.player.damage = 0;
                ActivityTwo.player.health += ActivityTwo.currentSituation.dHealth;
                ActivityTwo.player.damage += ActivityTwo.currentSituation.dDamage;
                if (ActivityTwo.player.health <= 0) {
                    ActivityTwo.player.health = 0;
                    ActivityTwo.nameCurrentSituation = "death";
                    ActivityTwo.currentSituation = ActivityTwo.story.situations.get(ActivityTwo.nameCurrentSituation);
                }
                ActivityTwo.currentSituation = ActivityTwo.story.situations.get(ActivityTwo.nameCurrentSituation);
                if (ActivityTwo.currentSituation.act == 2)
                    startActivity(new Intent(ActivityOne.this, ActivityTwo.class));
                else {
                    textView1.setText("Здоровье = " + ActivityTwo.player.health);
                    textView2.setText("Урон = " + ActivityTwo.player.damage);
                    if (ActivityTwo.nameCurrentSituation.equals("battle")) {
                        ActivityTwo.textViewMH.setText("Здоровье монстра = " + ActivityTwo.monster.health);
                        ActivityTwo.textViewMD.setText("Урон монстра = " + ActivityTwo.monster.damage);
                    } else {
                        ActivityTwo.textViewMH.setText("");
                        ActivityTwo.textViewMD.setText("");
                    }
                    textView3.setText(ActivityTwo.currentSituation.text);
                    button1.setText(ActivityTwo.currentSituation.Ch1text);
                }
            }
        });
    }
}
