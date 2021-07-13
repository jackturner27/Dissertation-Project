package com.example.FinalYearProject;

import java.io.Serializable;

public class Block implements Serializable {

    private int current;
    private int original;
    private int previous;
    private String text;
    private Type type;

    public Block(String text, Type type) {
        this.text = text;
        this.type = type;
    }

    public Block(String text){
        this.text = text;
    }

    public void updateCurrent(int newCurrent) {
        this.setPrevious(this.current);
        this.setCurrent(newCurrent);
    }

    public void resetBlock() {
        this.setCurrent(this.getOriginal());
        this.setPrevious(this.getOriginal());
    }

    public Type getType() { return this.type; }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getOriginal() {
        return original;
    }

    public void setOriginal(int original) {
        this.original = original;
    }

    public int getPrevious() {
        return previous;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
