package com.example.FinalYearProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class HomepageActivity extends AppCompatActivity {

    static ArrayList<Problem> pl;
    static ArrayList<Integer> scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        AssetReader ar = new AssetReader(this);
        pl = ar.getProblemList();
        scores = ar.getScoreList();
    }

    public void startGame(View view){
        ArrayList<Problem> problems = new PlaylistConstructor().allProblems();
        Intent intent = new Intent(this, ProblemActivity.class);

        Bundle extras = new Bundle();
        extras.putInt("PROBLEM_ID",0);
        extras.putSerializable("PLAYLIST",problems);
        intent.putExtras(extras);

        startActivity(intent);
        finish();
    }

    public void levelSelect(View view) {
        Intent intent = new Intent(this, LevelSelect.class);
        startActivity(intent);
        finish();
    }

    public void resetScores(View view) {
        for(int i=0;i<scores.size();i++) {
            scores.set(i, 0);
        }
        AssetWriter aw = new AssetWriter(this);
        aw.writeScores();
    }
}
