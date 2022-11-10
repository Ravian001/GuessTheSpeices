package com.example.guessthespecies;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String [] animals = {"Lion","Panda","Giraffe","Dog","Cheetah","Elephant","Snake","Fox", "Gorilla", "Wolf", "Badger", "Zebra", "Rabbit", "Koala"};
    String [] birds = {"Parrot","Eagle","Vulture","penguin","Hawk","Turkey","Hen","Quail","Raven","Duck","Crow", "Falcon", "Peacock", "Emu", "Kingfisher"};
    String [] insects = {"Ant","Cockroach","Mantis","Housefly","Bee", "Centipede", "Ladybird", "Beetle", "Lice", "Butterfly", "Cricket", "Silverfish"};
    String [] marines ={"Octopus", "Squid", "Goldfish", "Shark", "Whale", "Eel", "Shrimp", "Starfish", "Dolphin", "Sea lion", "Turtle", "Angler fish"};
    Button btnOfAnimal, btnOfBird, btnOfInsect, btnOfMarine;
    TextView textView, textViewAnswer, textViewAnimalInformation,
            TextViewBirdInformation, TextViewInsectInformation, TextViewMarineInformation, TextViewCorrect;
    int category = 0, index=0, animalCorrectCount, animalWrongCount,
            birdCorrectCount, birdWrongCount, insectCorrectCount, insectWrongCount, marineCorrectCount, marineWrongCount;
    String answer = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.organismName);
        btnOfAnimal = findViewById(R.id.btnAnimal);
        btnOfAnimal.setOnClickListener(this);
        btnOfBird = findViewById(R.id.btnBird);
        btnOfBird.setOnClickListener(this);
        btnOfInsect = findViewById(R.id.btnInsect);
        btnOfInsect.setOnClickListener(this);
        btnOfMarine = findViewById(R.id.btnMarine);
        btnOfMarine.setOnClickListener(this);
        textViewAnswer = findViewById(R.id.textViewResult);
        textViewAnimalInformation = findViewById(R.id.textViewResultAnimal);
        TextViewBirdInformation = findViewById(R.id.textViewResultBird);
        TextViewInsectInformation = findViewById(R.id.textViewResultInsect);
        TextViewMarineInformation = findViewById(R.id.textViewResultMarine);
        TextViewCorrect = findViewById(R.id.CorrectAnswer);

        GenerateSpecie();


    }

    private void GenerateSpecie() {
        Random rnd = new Random();
        category = rnd.nextInt(4);
        if (category ==0){
            index = rnd.nextInt(animals.length);
            textView.setText(animals[index]);
            answer = "animals";
        } else if (category ==1){
            index = rnd.nextInt(birds.length);
            textView.setText(birds[index]);
            answer = "birds";
        }else if (category ==2){
            index = rnd.nextInt(insects.length);
            textView.setText(insects[index]);
            answer = "insects";
        }
     else if (category ==3){
        index = rnd.nextInt(marines.length);
        textView.setText(marines[index]);
        answer = "marines";
    }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAnimal:
                if (answer == "animals") {
                    textViewAnswer.setText("Great");
                    textViewAnswer.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.highlighted_text_material_light));
                    animalCorrectCount++;
                    TextViewCorrect.setText("Correct :)");

                } else {
                    textViewAnswer.setText("Wrong");
                    textViewAnswer.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.m3_ref_palette_tertiary50));
                    animalWrongCount++;
                    TextViewCorrect.setText("Correct answer is: "+ answer);
                }
                textViewAnimalInformation.setText("Animals\nRight " + animalCorrectCount + "\nWrong " + animalWrongCount);
                break;
            case R.id.btnBird:
                if (answer == "birds") {
                    textViewAnswer.setText("Fantastic");
                    textViewAnswer.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.highlighted_text_material_light));
                    birdCorrectCount++;
                    TextViewCorrect.setText("Correct :)");
                } else {
                    textViewAnswer.setText("Oops");
                    textViewAnswer.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.m3_ref_palette_tertiary50));
                    birdWrongCount++;
                    TextViewCorrect.setText("Correct answer is: "+ answer);
                }
                TextViewBirdInformation.setText("Birds\nRight " + birdCorrectCount + "\nWrong " + birdWrongCount);
                break;
            case R.id.btnInsect:
                if (answer == "insects") {
                    textViewAnswer.setText("Good");
                    textViewAnswer.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.highlighted_text_material_light));
                    insectCorrectCount++;
                    TextViewCorrect.setText("Correct :)");
                } else {
                    textViewAnswer.setText("Damn");
                    textViewAnswer.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.m3_ref_palette_tertiary50));
                    insectWrongCount++;
                    TextViewCorrect.setText("Correct answer is: "+ answer);
                }
                TextViewInsectInformation.setText("Insects\nRight " + insectCorrectCount + "\nWrong " + insectWrongCount);
                break;
            case R.id.btnMarine:
                if (answer == "marines") {
                    textViewAnswer.setText("Fabulous");
                    textViewAnswer.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.highlighted_text_material_light));
                    marineCorrectCount++;
                    TextViewCorrect.setText("Correct :)");
                } else {
                    textViewAnswer.setText("Try Again");
                    textViewAnswer.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.m3_ref_palette_tertiary50));
                    marineWrongCount++;
                    TextViewCorrect.setText("Correct answer is: "+ answer);
                }
                TextViewMarineInformation.setText("Marines\nRight " + marineCorrectCount + "\nWrong " + marineWrongCount);
                break;
        }
        GenerateSpecie();
    }

}

