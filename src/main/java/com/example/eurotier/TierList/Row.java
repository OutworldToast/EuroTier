package com.example.eurotier.TierList;

import java.util.ArrayList;

public class Row {
    private String label;
    private final ArrayList<String> countries = new ArrayList<>();

    public Row(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ArrayList<String> getCountries() {
        return countries;
    }

    public boolean addCountry(String country) {
        return countries.add(country);
    }

    public boolean removeCountry(String country) {
        return countries.remove(country);
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
