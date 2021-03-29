package com.example.kozquest;

import java.util.HashMap;

public class Story {
    HashMap<String, Situation> situations;

    Story() {
        situations = new HashMap<String, Situation>();
        Situation temp;
        String tempChoices[];

        temp = new Situation();
        temp.act = 2;
        temp.text = "На Вашем пути повстречался монстр, что прикажете делать?";
        temp.Ch1text = "Атаковать.";
        temp.Ch2text = "Убежать.";
        tempChoices = new String[2];
        tempChoices[0] = "battle";
        tempChoices[1] = "forest";
        temp.choices = tempChoices;
        situations.put("start", temp);

        temp = new Situation();
        temp.act = 2;
        temp.text = "На Вашем пути повстречался монстр, что прикажете делать?";
        temp.Ch1text = "Атаковать.";
        temp.Ch2text = "Убежать.";
        tempChoices = new String[2];
        tempChoices[0] = "battle";
        tempChoices[1] = "forest";
        temp.choices = tempChoices;
        situations.put("second", temp);

        temp = new Situation();
        temp.act = 2;
        temp.text = "Неизвестный предложил вам выпить, что прикажете делать?";
        temp.Ch1text = "Выпить.";
        temp.Ch2text = "Уйти.";
        tempChoices = new String[2];
        tempChoices[0] = "random";
        tempChoices[1] = "refuse";
        temp.choices = tempChoices;
        situations.put("forest", temp);

        temp = new Situation();
        temp.act = 1;
        temp.text = "Вы решили, что лучше ничего не брать у незнакомцев, может оно и к лучшему.";
        temp.Ch1text = "Идти дальше.";
        tempChoices = new String[1];
        tempChoices[0] = "second";
        temp.choices = tempChoices;
        situations.put("refuse", temp);

        temp = new Situation();
        tempChoices = new String[0];
        temp.choices = tempChoices;
        situations.put("random", temp);

        temp = new Situation();
        temp.act = 1;
        temp.text = "Этот негодяй дал Вам яду. Вы умерли в мучениях.";
        temp.Ch1text = "Начать сначала.";
        tempChoices = new String[1];
        tempChoices[0] = "start";
        temp.choices = tempChoices;
        situations.put("randomOne", temp);

        temp = new Situation();
        temp.act = 1;
        temp.dHealth = (int) (Math.random() * 5) + 2;
        temp.text = "Эта жидкость восстановила Вам " + temp.dHealth * 3 + " очков здоровья.";
        temp.Ch1text = "Идти дальше.";
        tempChoices = new String[1];
        tempChoices[0] = "second";
        temp.choices = tempChoices;
        situations.put("randomTwo", temp);

        temp = new Situation();
        temp.act = 1;
        temp.dHealth = ((int) (Math.random() * 5) + 2);
        temp.text = "Вы выпили жидкость для мытья посуды и отравились на " + temp.dHealth * 3 + " очков здоровья";
        temp.Ch1text = "Идти дальше.";
        temp.dHealth = -temp.dHealth;
        tempChoices = new String[1];
        tempChoices[0] = "second";
        temp.choices = tempChoices;
        situations.put("randomThree", temp);

        temp = new Situation();
        temp.act = 1;
        temp.text = "Это оказалось снотворное, пока Вы спали, незнакомец отнял у Вас оружие, Ваш урон равен 0.";
        temp.Ch1text = "Идти дальше.";
        tempChoices = new String[1];
        tempChoices[0] = "second";
        temp.choices = tempChoices;
        situations.put("randomFour", temp);

        temp = new Situation();
        temp.act = 1;
        temp.dDamage = (int) (Math.random() * 2) + 2;
        temp.text = "Вы выпили протеиновый коктейль, теперь Вы стали сильнее на " + temp.dDamage * 3 + " очков урона.";
        temp.Ch1text = "Идти дальше.";
        tempChoices = new String[1];
        tempChoices[0] = "second";
        temp.choices = tempChoices;
        situations.put("randomFive", temp);

        temp = new Situation();
        temp.act = 1;
        temp.dDamage = ((int) (Math.random() * 2) + 2);
        temp.text = "После выпитого у вас начались головные боли, и Вы бьёте на " + temp.dDamage * 3 + " очков урона меньше.";
        temp.Ch1text = "Идти дальше.";
        temp.dDamage = -temp.dDamage;
        tempChoices = new String[1];
        tempChoices[0] = "second";
        temp.choices = tempChoices;
        situations.put("randomSix", temp);

        temp = new Situation();
        temp.act = 2;
        temp.text = "Вы ударили монстра, а он Вас.";
        temp.Ch1text = "Продолжать драться.";
        temp.Ch2text = "Убежать.";
        tempChoices = new String[2];
        tempChoices[0] = "battle";
        tempChoices[1] = "forest";
        temp.choices = tempChoices;
        situations.put("battle", temp);

        temp = new Situation();
        temp.act = 1;
        temp.text = "Вы убили монстра. Поздравляю.";
        temp.Ch1text = "Идти дальше.";
        tempChoices = new String[1];
        tempChoices[0] = "forest";
        temp.choices = tempChoices;
        situations.put("kill", temp);

        temp = new Situation();
        temp.act = 1;
        temp.text = "Вы умерли.";
        temp.Ch1text = "Начать сначала.";
        tempChoices = new String[1];
        tempChoices[0] = "start";
        temp.choices = tempChoices;
        situations.put("death", temp);
    }
}
