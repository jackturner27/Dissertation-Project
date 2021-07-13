package com.example.FinalYearProject;

import java.util.ArrayList;

import static com.example.FinalYearProject.HomepageActivity.pl;

public class PlaylistConstructor {

    public PlaylistConstructor() {

    }

    public ArrayList allProblems() {
        return pl;
    }

    /**
     * Return all problems from the given list that are tagged as having loops
     */
    public ArrayList filterLoops(ArrayList<Problem> problems) {
        return filter(problems, "LOOP");
    }

    /**
     * Return all problems from the given list that are tagged as having ifs
     */
    public ArrayList filterIfs(ArrayList<Problem> problems) {
        return filter(problems, "IF");
    }

    public ArrayList filter(ArrayList<Problem> problems, String tag) {
        ArrayList<Problem> newProblems = new ArrayList<>();
        for (Problem p : problems) {
            if(p.getTags().contains(tag)) {
                newProblems.add(p);
            }
        }
        return newProblems;
    }

}
