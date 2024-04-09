package com.example.commidtermnguyenthetuyen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button previousButton, nextButton, trueButton, falseButton, submitButton;
    private RecyclerView recyclerView;
    private TextView questionTextView;
    private ArrayList<String> questions;
    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = findViewById(R.id.bt_buttonsubmit);

        submitButton = findViewById(R.id.bt_buttonsubmit);

//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//                startActivity(intent);
//            }
//        });


        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);
        trueButton = findViewById(R.id.bt_buttontrue);
        falseButton = findViewById(R.id.bt_buttonfailse);
        submitButton = findViewById(R.id.bt_buttonsubmit);
        recyclerView = findViewById(R.id.recyclerView);
        questionTextView = findViewById(R.id.textView);

        questions = new ArrayList<>();
        questions.add("Canberra is the capital of Australia.");
        questions.add("how you want crush.");
        questions.add("lam sao de giau");

        showQuestion();
        questions.add("lam sao de giau");

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trueButton.setBackgroundColor(getResources().getColor(R.color.purple));
                falseButton.setBackgroundColor(getResources().getColor(R.color.purple));
                showPreviousQuestion();
            }

        });


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trueButton.setBackgroundColor(getResources().getColor(R.color.purple));
                falseButton.setBackgroundColor(getResources().getColor(R.color.purple));
                showNextQuestion();

            }
        });

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trueButton.setBackgroundColor(getResources().getColor(R.color.blue));
                checkAnswer(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                falseButton.setBackgroundColor(getResources().getColor(R.color.blue));
                checkAnswer(false);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Answers submitted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }

        });

    }


    private void showQuestion() {
        questionTextView.setText(questions.get(currentQuestionIndex));

    }

    private void showNextQuestion() {

        if (currentQuestionIndex < questions.size() - 1) {
            currentQuestionIndex++;
            showQuestion();
        }
    }

    private void showPreviousQuestion() {

        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            showQuestion();
        }
    }

    private void checkAnswer(boolean userAnswer) {

        Toast.makeText(MainActivity.this, "Answer checked!", Toast.LENGTH_SHORT).show();
    }
}
