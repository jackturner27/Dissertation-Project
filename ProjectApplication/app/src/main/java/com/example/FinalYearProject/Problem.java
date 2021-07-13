package com.example.FinalYearProject;

import java.io.Serializable;

public class Problem implements Serializable {

    private int problemID;
    private Block[] blocks;
    private String probDesc;
    private String[][] probLines;
    private String[] solution;
    private String tags;

    public Problem(int problemID, String probDesc, String tags ,String[][] probLines, String[] solution, String[] blocks){
        this.problemID = problemID;
        this.probDesc = probDesc;
        this.probLines = probLines;
        this.solution = solution;
        this.tags = tags;
        this.blocks = new Block[blocks.length];
        for(int i=0;i<blocks.length;i++) {
            String[] text = blocks[i].split("`");
            switch(text[1]) {
                case "OP":
                    this.blocks[i] = new Block(text[0], Type.OPERATOR);
                    break;
                case "CON":
                    this.blocks[i] = new Block(text[0], Type.CONSTANT);
                    break;
                case "DT":
                    this.blocks[i] = new Block(text[0], Type.DATATYPE);
                    break;
                case "VAR":
                    this.blocks[i] = new Block(text[0], Type.VARIABLE);
                    break;
                case "MISC":
                    this.blocks[i] = new Block(text[0], Type.MISC);
                    break;
                default:
                    System.out.println("SLOTS: Setting slot to default MISC type");
                    this.blocks[i] = new Block(text[0], Type.MISC);
                    break;
            }
        }
    }

    public Block[] getBlocks() {
        return blocks;
    }

    public void setBlocks(Block block, int index) {
        this.blocks[index] = block;
    }

    public String getProbDesc() {
        return probDesc;
    }

    public void setProbDesc(String probDesc) {
        this.probDesc = probDesc;
    }

    public String[][] getProbLines() {
        return probLines;
    }

    public void setProbLines(String[][] probLines) {
        this.probLines = probLines;
    }

    public String[] getSolution() {
        return solution;
    }

    public void setSolution(String[] solution) {
        this.solution = solution;
    }

    public int getProblemID() {
        return problemID;
    }

    public void setProblemID(int problemID) {
        this.problemID = problemID;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
