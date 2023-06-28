package com.example.eurotier.Tracker;

import com.example.eurotier.Loaders.LoaderFactory;
import com.example.eurotier.TierList.ITierList;
import com.example.eurotier.TierList.Row;
import com.example.eurotier.TierList.TierList;

import java.io.File;
import java.util.ArrayList;

public class Tracker {

    private static ITierList currentList;
    private final ArrayList<TierList> lists = new ArrayList<>();

    public Tracker() {

        int lowerLimit = 1959;
        int upperLimit = 2023;

        for (int i = lowerLimit; i <= upperLimit; i++) {
            createList(String.valueOf(i));
        }

    }

    public static void setCurrentList(TierList tierList) {
        currentList = tierList;
    }

    public TierList findList(String label){

        for(TierList list : lists) {
            if (list.getLabel().equalsIgnoreCase(label)) {
                return list;
            }
        }

        return null;

    }

    public ITierList getCurrentList() {
        return currentList;
    }

    public TierList createList(String label) {
        //TODO: add search logic (if foundinfile: generate())
        return new TierList(label);
    }

    public void clearList(String label) {

        //TODO: logic should be moved to TierList;

        TierList list = findList(label);

        for (Row row : list.getRows()) {
            row.getCountries().clear();
        }

    }

    public TierList generate(File file) {
        //TODO: factor in NULL
        LoaderFactory factory = new LoaderFactory();
        return factory.createLoader(file).load(file);
    }

}
