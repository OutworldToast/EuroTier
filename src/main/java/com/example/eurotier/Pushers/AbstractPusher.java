package com.example.eurotier.Pushers;

import com.example.eurotier.IObservable.Observer;
import com.example.eurotier.TierList.Row;
import com.example.eurotier.TierList.TierList;

import java.util.ArrayList;

public abstract class AbstractPusher implements Observer<TierList> {

    public boolean push(TierList tierList) {

        ArrayList<Row> rows = parse(tierList);
        Object location = locate(tierList.getLabel());

        for (Row row : rows) {
            if (!write(location, row)) {
                return false;
            }
        }

        return true;
    }
    ArrayList<Row> parse(TierList tierList) {
        return tierList.getRows();
    }
    abstract Object locate(String label);
    abstract boolean write(Object location, Row row);

}
