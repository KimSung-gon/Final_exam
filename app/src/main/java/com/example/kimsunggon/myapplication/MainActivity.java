package com.example.kimsunggon.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    EditText editText1;
    Button result;
    Button preQuestion;
    Button pushAnswer;
    Button nextQuestion;
    Intent intent1;
    static int count = 0;

    ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questions = new ArrayList<Question>();
        questions.add(new Question("1.보기 중 가장 큰 수를 고르시오\n 1)0 2)4 3)50", 3));
        questions.add(new Question("2.보기 중 가장 작은 수를 고르시오\n 1)0 2)4 3)50", 1));
        questions.add(new Question("3.보기 중 음수를 고르시오\n 1)-5 2)4 3)50", 1));
        questions.add(new Question("4.보기 중 알파벳을 고르시오\n 1)0 2)A 3)50", 2));

        textView1 = (TextView) findViewById(R.id.tv_questions);
        textView1.setText(questions.get(count).question);

        editText1 = (EditText) findViewById(R.id.et_input);
        preQuestion = (Button) findViewById(R.id.bt_left);
        pushAnswer = (Button) findViewById(R.id.bt_insert);
        nextQuestion = (Button) findViewById(R.id.bt_right);
        result = (Button) findViewById(R.id.bt_result);

        preQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count == 0) {
                    Toast.makeText(v.getContext(), "현재 첫번째 문제입니다", Toast.LENGTH_LONG).show();
                } else {
                    count--;
                    Toast.makeText(v.getContext(), "현재 " + (int) (count + 1) + "번째 문제입니다", Toast.LENGTH_LONG).show();
                }
                textView1.setText(questions.get(count).question);
            }
        });

        pushAnswer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext() , (int)(count+1) + "번 문제 "+ editText1.getText().toString() +"보기 선택", Toast.LENGTH_LONG).show();
                if(editText1.getText().toString().equals(questions.get(count).correctAnswer))
                    questions.get(count).userAnswer++;
            }
        });

        nextQuestion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(count == 3) {
                    Toast.makeText(v.getContext(), "현재 마지막 문제입니다", Toast.LENGTH_LONG).show();
                }
                else {
                    count++;
                    Toast.makeText(v.getContext(), "현재 " + (int)(count+1) + "번째 문제입니다", Toast.LENGTH_LONG).show();
                }
                textView1.setText(questions.get(count).question);
            }
        });

        result.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // create intent instance
                int tmp = 0;
                for(int i=0; i<questions.size(); i++)
                    if(questions.get(i).userAnswer == 1)
                        tmp += questions.get(i).userAnswer;

                Toast.makeText(v.getContext(), "현재 맞힌 갯수는 "+ tmp +"개입니다", Toast.LENGTH_LONG).show();

                intent1 = new Intent(MainActivity.this, resultActivity.class);

                String printAnswer = null;

                for(int i=0; i<questions.size(); i++)
                    if(questions.get(i).correctAnswer == 1)
                        printAnswer = (int)(count+1) + "번문제 맞음\n";
                    else
                        printAnswer = (int)(count+1) + "번문제 틀림\n";

                intent1.putExtra("name",printAnswer);
                startActivity(intent1);
            }
        });
    }
}
