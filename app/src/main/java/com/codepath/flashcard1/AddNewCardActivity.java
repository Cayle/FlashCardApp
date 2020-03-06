package com.codepath.flashcard1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddNewCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_card);

        findViewById(R.id.closeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = getIntent().getStringExtra("answer");
                String s2 = getIntent().getStringExtra("question");
                Intent data = new Intent();
                data.putExtra("answers", s1);
                data.putExtra("questions", s2);
                setResult(RESULT_OK, data);
                finish();
            }
        });

        findViewById(R.id.saveBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String theAnswer = ((EditText) findViewById(R.id.answer)).getText().toString();
                String theQuestion = ((EditText) findViewById(R.id.question)).getText().toString();
                Intent data = new Intent();
                data.putExtra("answers", theAnswer);
                data.putExtra("questions", theQuestion);
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}
