package com.example.FinalYearProject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

@SuppressLint("AppCompatCustomView")
public class Slot extends android.widget.TextView {

    private boolean isEmpty;
    private String currentText;
    private Type type;

    @RequiresApi(api = Build.VERSION_CODES.M)
    public Slot (Context context) {
        super(context);
        this.isEmpty = true;
        resetCurrentText();
        this.setId((int) System.currentTimeMillis() * 2);
        this.setDefaultPadding();
        this.setTextAppearance(R.style.problemText);
        this.setBackgroundResource(R.color.colorSlots);
        this.type = Type.MISC;
    }

    public void calcNewPadding() {
        if(this.currentText.length() < 3) {
            this.setPadding(40,20,40,20);
        } else {
            this.setDefaultPadding();
        }
    }

    public void setDefaultPadding() {
        this.setPadding(20, 20, 20, 20);
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public void setEmpty() {
        this.isEmpty = true;
        resetCurrentText();
        this.setText(this.currentText);
        this.setOnTouchListener(null);
        this.setBackgroundResource(R.color.colorSlots);
    }

    public void setFull(String text) {
        this.isEmpty = false;
        setCurrentText(text);
        this.setBackgroundResource(R.color.colorBlocks);
    }

    public String getCurrentText() {
        return currentText;
    }

    public void setCurrentText(String currentText) {
        this.currentText = currentText;
        calcNewPadding();
        this.setText(this.currentText);
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void resetCurrentText() {
        this.currentText = "      ";
        this.setText(this.currentText);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setCorrect() {
        this.setBackgroundResource(android.R.color.transparent);
        this.setDefaultPadding();
        this.setTextAppearance(R.style.correctText);
        this.setOnTouchListener(null);
        this.setOnDragListener(null);
        this.isEmpty = false;
    }


}
