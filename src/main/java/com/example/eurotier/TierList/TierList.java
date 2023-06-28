package com.example.eurotier.TierList;

import java.util.ArrayList;


public class TierList implements ITierList {

    private final EventManager eventManager = new EventManager();
    private final ArrayList<Row> rows = new ArrayList<>();
    private String label;

    public TierList(String label) {
        this(label, false);
    }

    public TierList(String label, boolean isCustom) {
        this.label = label;

        if (!isCustom) {
          createRows();
        }
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public TierReturnType createRows() {
        String labels = "SABCDEF";
        TierReturnType result = null;
        for (int i = 0; i < labels.length(); i++) {
            result = addRow(new Row(String.valueOf(labels.charAt(i))));
            if (result != TierReturnType.SUCCESS) {
                return result;
            }
        }
        return result;
    }

    public TierReturnType getTierReturnType(boolean isSuccesful) {

        return ((isSuccesful) ? TierReturnType.SUCCESS : TierReturnType.ERROR);

    }

    @Override
    public Row getRow(String label) {

        for (Row row : rows) {
            if (row.getLabel().equalsIgnoreCase(label)) {
                return row;
            }
        }
        return null;
    }

    public TierReturnType addRow(Row row) {

        return getRow(row.getLabel()) == null ? getTierReturnType(rows.add(row)) : TierReturnType.EXISTS;

    }

    @Override
    public TierReturnType addItem(Row row, String item) {

        return row.hasCountry(item) ? TierReturnType.EXISTS : getTierReturnType(rows.get(rows.indexOf(row)).addCountry(item));

    }

    @Override
    public TierReturnType removeItem(Row row, String item) {

        return row.hasCountry(item) ? getTierReturnType(rows.get(rows.indexOf(row)).removeCountry(item)) : TierReturnType.NOTFOUND;

    }

    @Override
    public TierReturnType changeName(Row row, String newName) {

        Row oldRow = getRow(row.getLabel());
        if (oldRow != null) {
            oldRow.setLabel(newName);
            return TierReturnType.SUCCESS;
        } else {
            return TierReturnType.NOTFOUND;
        }

    }

    @Override
    public TierReturnType commit(String eventType) {
        eventManager.alert(eventType, this);
        return TierReturnType.SUCCESS;
    }

}
