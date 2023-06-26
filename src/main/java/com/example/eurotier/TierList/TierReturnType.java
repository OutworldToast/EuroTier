package com.example.eurotier.TierList;

public class TierReturnType {

    public static final TierReturnType SUCCESS = new TierReturnType("Success");
    public static final TierReturnType ERROR = new TierReturnType("Error");
    public static final TierReturnType NOTFOUND = new TierReturnType("Not found");

    public String label;

    public TierReturnType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}