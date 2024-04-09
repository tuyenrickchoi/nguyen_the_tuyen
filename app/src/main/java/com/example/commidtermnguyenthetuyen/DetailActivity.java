package com.example.commidtermnguyenthetuyen;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {


    private ListView answerListView;

    private ArrayList<String> answers;
    private ArrayAdapter<String> answerAdapter;

    private DatabaseHelper databaseHelper;
    private static final String KEY_ANSWERS = "answers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        answerListView = findViewById(R.id.answerListView);
        if (savedInstanceState != null) {
            answers = savedInstanceState.getStringArrayList(KEY_ANSWERS);
        } else {

            answers = new ArrayList<>();

            answers.add("Canberra is the capital of Australia      sure");
            answers.add("lam sao de giau      sure");
            answers.add("lam sao de ngheo      sure");
            answers.add("lam sao de co ngui iu     sure");


            updateListView();

        }


// loi dabalite
//        databaseHelper = new DatabaseHelper(this);
//
//
//        String question = getIntent().getStringExtra("question");
//
//
//
//        loadAnswersFromDatabase();

    }


//    private void loadAnswersFromDatabase() {
//        answers = new ArrayList<>();
//        Cursor cursor = databaseHelper.getAllAnswers();
//
//        if (cursor != null && cursor.moveToFirst()) {
//            do {
//                @SuppressLint("Range") String answer = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ANSWER));
//                answers.add(answer);
//            } while (cursor.moveToNext());
//            cursor.close();
//        }
//
//
//        answerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, answers);
//        answerListView.setAdapter(answerAdapter);
//    }

    //xoay mh
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(KEY_ANSWERS, answers);
    }

    // Cập nhật dữ liệu trong ListView
    private void updateListView() {
        answerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, answers);
        answerListView.setAdapter(answerAdapter);
    }
}


