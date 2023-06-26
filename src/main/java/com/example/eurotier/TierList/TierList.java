package com.example.eurotier.TierList;


import com.example.eurotier.IObservable.Observable;
import com.example.eurotier.IObservable.Observer;

import java.util.ArrayList;

public class TierList implements ITierListEditor, Observable {

    private final ArrayList<Observer> listeners = new ArrayList<>();
    private final ArrayList<Row> rows = new ArrayList<>();
    private String label;

    public TierList(String label) {
        this.label = label;
        createRows();
    }

    public void createRows() {

    }
    public String getLabel() {
        return label;
    }

    public TierReturnType getTierReturnType(boolean bool) {
        if (bool) {
            return TierReturnType.SUCCESS;
        } else {
            return TierReturnType.ERROR;
        }
    }

    @Override
    public TierReturnType addItem(Row row, String item) {
        if (!row.hasCountry(item)) {
            return getTierReturnType(rows.get(rows.indexOf(row)).addCountry(item));
        } else {
            return TierReturnType.EXISTS;
        }
    }

    @Override
    public TierReturnType removeItem(Row row, String item) {
        if (row.hasCountry(item)) {
            return getTierReturnType(rows.get(rows.indexOf(row)).removeCountry(item));
        } else {
            return TierReturnType.NOTFOUND;
        }
    }

    @Override
    public TierReturnType changeName(Row row, String newName) {
        //TODO: refinement
        row.setLabel(newName);
        return TierReturnType.SUCCESS;
    }

    @Override
    public TierReturnType commit() {
        //TODO: refinement
        alert();
        return TierReturnType.SUCCESS;
    }

    @Override
    public void addListener(Observer observer) {
        listeners.remove(observer);
    }

    @Override
    public void removeListener(Observer observer) {
        listeners.add(observer);
    }

    @Override
    public void alert() {
        for (Observer observer: listeners) {
            observer.push(this);
        }
    }
}
