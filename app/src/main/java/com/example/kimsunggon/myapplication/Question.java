package com.example.kimsunggon.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by KimSunggon on 2015-12-17.
 */

public class Question extends AppCompatActivity{

    public String question;
    public int correctAnswer;
    public int userAnswer;

    public Question(String q, int answer){
        question = q;
        correctAnswer = answer;
        userAnswer = -1;
    }

    public boolean isCorrect(int a){
        if(correctAnswer == a)
            return true;
        else
            return false;
    }

    public String getQuestion(){
        return question;
    }

    public void setUserAnswer(int answer){
        userAnswer = answer;
    }

    public void resetAnswer(){
        userAnswer = -1;
    }
}
