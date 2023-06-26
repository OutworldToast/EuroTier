package com.example.eurotier.TierList;

import java.util.ArrayList;

public class Row {
    private String label;
    private final ArrayList<String> countries = new ArrayList<>();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void addCountry(String country) {
        countries.add(country);
    }

    public void removeCountry(String country) {
        countries.remove(country);
    }

    public boolean hasCountry(String sought) {
        for (String country: countries) {
            if (country.equalsIgnoreCase(sought)) {
                return true;
            }
        }
        return false;
    }
}
