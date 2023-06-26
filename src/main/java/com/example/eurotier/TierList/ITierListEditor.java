package com.example.eurotier.TierList;

public interface ITierListEditor {
    public TierReturnType addItem(Row row, String item);
    public TierReturnType removeItem(Row row, String item);
    public TierReturnType changeName(Row row);
    public TierReturnType commit();
}
