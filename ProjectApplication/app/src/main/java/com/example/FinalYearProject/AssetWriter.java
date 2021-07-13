package com.example.FinalYearProject;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import static com.example.FinalYearProject.HomepageActivity.scores;

public class AssetWriter {

    private Context context;

    public AssetWriter(Context context){
        this.context = context;
    }

    public void writeScores() {
        File file = new File(context.getFilesDir(), "scores.txt");
        System.out.println("WRITING: " + file.toString());
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(scores);
            out.close();
        }  catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }  catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
