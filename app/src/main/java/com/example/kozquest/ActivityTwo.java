package com.example.kozquest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {

    static Situation currentSituation = new Situation();
    static String nameCurrentSituation = "start";
    static Monster monster = new Monster();
    static Player player = new Player();
    static Story story = new Story();
    static TextView textViewMH;
    static TextView textViewMD;
    static boolean sworld = true;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    static int random;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitytwo);

        textViewMH = findViewById(R.id.textViewMH);
        textViewMD = findViewById(R.id.textViewMD);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        currentSituation = story.situations.get(nameCurrentSituation);
        if (nameCurrentSituation.equals("start")) {
            player.health = 150;
            player.damage = (int) (Math.random() * 9) + 6;
            sworld = true;
        }
        if (nameCurrentSituation.equals("random")) {
            if (sworld) {
                random = (int) (Math.random() * 5);
                switch (random) {
                    case 0:
                        nameCurrentSituation = "randomOne";
                        break;
                    case 1:
                        nameCurrentSituation = "randomTwo";
                        break;
                    case 2:
                        nameCurrentSituation = "randomThree";
                        break;
                    case 3:
                        nameCurrentSituation = "randomFour";
                        sworld = false;
                        break;
                    case 4:
                        nameCurrentSituation = "randomFive";
                        break;
                    case 5:
                        nameCurrentSituation = "randomSix";
                        break;
                }
            } else {
                random = (int) (Math.random() * 4);
                switch (random) {
                    case 0:
                        nameCurrentSituation = "randomOne";
                        break;
                    case 1:
                        nameCurrentSituation = "randomTwo";
                        break;
                    case 2:
                        nameCurrentSituation = "randomThree";
                        break;
                    case 3:
                        nameCurrentSituation = "randomFive";
                        break;
                    case 4:
                        nameCurrentSituation = "randomSix";
                        break;
                }
            }
            currentSituation = story.situations.get(nameCurrentSituation);
        }
        if (nameCurrentSituation.equals("randomFour"))
            player.damage = 0;
        if (nameCurrentSituation.equals("battle")) {
            player.health -= monster.damage;
            monster.health -= player.damage;
        }
        player.health += currentSituation.dHealth;
        player.damage += currentSituation.dDamage;
        monster.health += currentSituation.mHealth;
        if (player.health <= 0) {
            player.health = 0;
            nameCurrentSituation = "death";
            currentSituation = story.situations.get(nameCurrentSituation);
        }
        textView1.setText("Здоровье = " + player.health);
        textView2.setText("Урон = " + player.damage);
        if (nameCurrentSituation.equals("battle")) {
            textViewMH.setText("Здоровье монстра = " + monster.health);
            textViewMD.setText("Урон монстра = " + monster.damage);
        } else {
            textViewMH.setText("");
            textViewMD.setText("");
        }
        textView3.setText(currentSituation.text);
        button1.setText(currentSituation.Ch1text);
        button2.setText(currentSituation.Ch2text);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameCurrentSituation = currentSituation.choices[0];
                currentSituation = story.situations.get(nameCurrentSituation);
                if (nameCurrentSituation.equals("start")) {
                    player.health = 150;
                    player.damage = (int) (Math.random() * 9) + 6;
                    sworld = true;
                }
                if (nameCurrentSituation.equals("random")) {
                    if (sworld) {
                        random = (int) (Math.random() * 5);
                        switch (random) {
                            case 0:
                                nameCurrentSituation = "randomOne";
                                break;
                            case 1:
                                nameCurrentSituation = "randomTwo";
                                break;
                            case 2:
                                nameCurrentSituation = "randomThree";
                                break;
                            case 3:
                                nameCurrentSituation = "randomFour";
                                sworld = false;
                                break;
                            case 4:
                                nameCurrentSituation = "randomFive";
                                break;
                            case 5:
                                nameCurrentSituation = "randomSix";
                                break;
                        }
                    } else {
                        random = (int) (Math.random() * 4);
                        switch (random) {
                            case 0:
                                nameCurrentSituation = "randomOne";
                                break;
                            case 1:
                                nameCurrentSituation = "randomTwo";
                                break;
                            case 2:
                                nameCurrentSituation = "randomThree";
                                break;
                            case 3:
                                nameCurrentSituation = "randomFive";
                                break;
                            case 4:
                                nameCurrentSituation = "randomSix";
                                break;
                        }
                    }
                    currentSituation = story.situations.get(nameCurrentSituation);
                }
                if (nameCurrentSituation.equals("randomFour"))
                    player.damage = 0;
                if (nameCurrentSituation.equals("battle")) {
                    player.health -= monster.damage;
                    monster.health -= player.damage;
                }
                player.health += currentSituation.dHealth;
                player.damage += currentSituation.dDamage;
                monster.health += currentSituation.mHealth;
                if (player.health <= 0) {
                    player.health = 0;
                    nameCurrentSituation = "death";
                    currentSituation = story.situations.get(nameCurrentSituation);
                }
                if (monster.health <= 0) {
                    nameCurrentSituation = "kill";
                    currentSituation = story.situations.get(nameCurrentSituation);
                    monster.health = (int) (Math.random() * 9) + 31;
                    monster.damage = (int) (Math.random() * 4) + 6;
                }
                if (currentSituation.act == 1)
                    startActivity(new Intent(ActivityTwo.this, ActivityOne.class));
                else {
                    textView1.setText("Здоровье = " + player.health);
                    textView2.setText("Урон = " + player.damage);
                    if (nameCurrentSituation.equals("battle")) {
                        textViewMH.setText("Здоровье монстра = " + monster.health);
                        textViewMD.setText("Урон монстра = " + monster.damage);
                    } else {
                        textViewMH.setText("");
                        textViewMD.setText("");
                    }
                    textView3.setText(currentSituation.text);
                    button1.setText(currentSituation.Ch1text);
                    button2.setText(currentSituation.Ch2text);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameCurrentSituation = currentSituation.choices[1];
                currentSituation = story.situations.get(nameCurrentSituation);
                if (nameCurrentSituation.equals("start")) {
                    player.health = 150;
                    player.damage = (int) (Math.random() * 9) + 6;
                    sworld = true;
                }
                if (nameCurrentSituation.equals("random")) {
                    if (sworld) {
                        random = (int) (Math.random() * 5);
                        switch (random) {
                            case 0:
                                nameCurrentSituation = "randomOne";
                                break;
                            case 1:
                                nameCurrentSituation = "randomTwo";
                                break;
                            case 2:
                                nameCurrentSituation = "randomThree";
                                break;
                            case 3:
                                nameCurrentSituation = "randomFour";
                                sworld = false;
                                break;
                            case 4:
                                nameCurrentSituation = "randomFive";
                                break;
                            case 5:
                                nameCurrentSituation = "randomSix";
                                break;
                        }
                    } else {
                        random = (int) (Math.random() * 4);
                        switch (random) {
                            case 0:
                                nameCurrentSituation = "randomOne";
                                break;
                            case 1:
                                nameCurrentSituation = "randomTwo";
                                break;
                            case 2:
                                nameCurrentSituation = "randomThree";
                                break;
                            case 3:
                                nameCurrentSituation = "randomFive";
                                break;
                            case 4:
                                nameCurrentSituation = "randomSix";
                                break;
                        }
                    }
                    currentSituation = story.situations.get(nameCurrentSituation);
                }
                if (nameCurrentSituation.equals("randomFour"))
                    player.damage = 0;
                if (nameCurrentSituation.equals("battle")) {
                    player.health -= monster.damage;
                    monster.health -= player.damage;
                }
                player.health += currentSituation.dHealth;
                player.damage += currentSituation.dDamage;
                monster.health += currentSituation.mHealth;
                if (player.health <= 0) {
                    player.health = 0;
                    nameCurrentSituation = "death";
                    currentSituation = story.situations.get(nameCurrentSituation);
                }
                if (currentSituation.act == 1)
                    startActivity(new Intent(ActivityTwo.this, ActivityOne.class));
                else {
                    textView1.setText("Здоровье = " + player.health);
                    textView2.setText("Урон = " + player.damage);
                    if (nameCurrentSituation.equals("battle")) {
                        textViewMH.setText("Здоровье монстра = " + monster.health);
                        textViewMD.setText("Урон монстра = " + monster.damage);
                    } else {
                        textViewMH.setText("");
                        textViewMD.setText("");
                    }
                    textView3.setText(currentSituation.text);
                    button1.setText(currentSituation.Ch1text);
                    button2.setText(currentSituation.Ch2text);
                }
            }
        });
    }
}
