package com.example.eurotier.TierList;


import com.example.eurotier.IObservable.Observable;
import com.example.eurotier.IObservable.Observer;
import com.example.eurotier.Pushers.AbstractPusher;

import java.util.ArrayList;

public class TierList implements ITierListEditor, Observable {

    private final ArrayList<Observer> listeners = new ArrayList<>();
    private final ArrayList<Row> rows = new ArrayList<>();
    private String label;

    public TierList(String label) {
        this.label = label;
    }
    @Override
    public TierReturnType addItem(Row row, String item) {
        return null;
    }

    @Override
    public TierReturnType removeItem(Row row, String item) {
        return null;
    }

    @Override
    public TierReturnType changeName(Row row) {
        return null;
    }

    @Override
    public TierReturnType commit() {
        return null;
    }
}
