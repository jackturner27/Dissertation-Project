package com.example.FinalYearProject;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class AssetReader {

    private ArrayList<Problem> problemList = new ArrayList<Problem>();
    private ArrayList<Integer> scoreList = new ArrayList<>();
    private Context context;

    public AssetReader(Context context) {
        this.context = context;
        loadAssets();
    }

    public ArrayList<Problem> getProblemList() {
        return problemList;
    }

    public ArrayList getScoreList() {
        return scoreList;
    }

    public void loadAssets() {
        readProblems();
        initialiseScoreList();
        readScores();
    }

    private void readProblems() {
        //Read Problems
        try {
            AssetManager assetManager = context.getAssets();
            DataInputStream textFileStream = new DataInputStream(assetManager.open("problems.txt"));
            Scanner scanner = new Scanner(textFileStream);
            Problem problem;
            while(scanner.hasNextLine()) {
                //read problem description
                String problemDesc = scanner.nextLine();

                String tags = scanner.nextLine();

                //read solution
                String[] solution = scanner.nextLine().split(",");

                //read blocks
                String[] blocks = scanner.nextLine().split(",");

                //read number of lines
                int numLines = Integer.parseInt(scanner.nextLine());

                String[][] problemLines = new String[numLines][];
                //read problem lines
                for(int i = 0; i < numLines; i++){
                    problemLines[i] = scanner.nextLine().split(",");
                }

                problem = new Problem(problemList.size(), problemDesc, tags, problemLines, solution, blocks);
                problemList.add(problem);
            }
        } catch (IOException ex) {
            System.out.println("CRASH: System failed to read text input.");
            return;
        } catch (Exception ex) {
            System.out.println("CRASH Reading attempt failed: " + ex.getMessage());
            ex.printStackTrace();
        }
        System.out.println("Setup: number of problems" + problemList.size());
    }

    private void initialiseScoreList() {
        for (int i=0;i<problemList.size();i++){
            scoreList.add(0);
        }
    }

    private void readScores() {
        //Read Scores
        try {
            File file = new File(context.getFilesDir(), "scores.txt");
            System.out.println("Reading: " + file.toString());
            if(file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fileInputStream);
                scoreList = (ArrayList) ois.readObject();
                ois.close();
                fileInputStream.close();
            } else {
                file.createNewFile();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        if(scoreList.size() < problemList.size()) {
            for(int i = scoreList.size(); i < problemList.size(); i++) {
                scoreList.add(0);
            }
        }
    }
}
