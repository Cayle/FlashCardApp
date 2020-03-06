package com.codepath.flashcard1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) { // this 100 needs to match the 100 we used when we called startActivityForResult!
            String newQuestion = data.getExtras().getString("questions"); // 'string1' needs to match the key we used when we put the string in the Intent
            String newAnswer = data.getExtras().getString("answers");
            Log.i("msg", newQuestion);
            Log.i("msg", newAnswer);

            ((TextView) findViewById(R.id.flashcard_question)).setText(newQuestion);
            ((TextView) findViewById(R.id.flashcard_answer)).setText(newAnswer);
        }
        else {
            setContentView(R.layout.activity_main);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Question", "clicked");
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.flashcard_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Answer", "cliked");
                findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.myBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddNewCardActivity.class);
                String theQuestion = (String)((TextView) findViewById(R.id.flashcard_question)).getText();
                String theAnswer = (String)((TextView) findViewById(R.id.flashcard_answer)).getText();
                intent.putExtra("answer", theAnswer);
                intent.putExtra("question", theQuestion);
                Log.i("check", theQuestion);
                startActivityForResult(intent, 100);
            }
        });


    }
}
