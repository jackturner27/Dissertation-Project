package com.example.FinalYearProject;

public enum Type {
    OPERATOR, CONSTANT, VARIABLE, DATATYPE, MISC;

    @Override
    public String toString() {
        switch(this) {
            case OPERATOR:
                return "operator";
            case CONSTANT:
                return "constant";
            case VARIABLE:
                return "variable";
            case DATATYPE:
                return "data type";
            case MISC:
            default:
                return "unknown";
        }
    }
}
