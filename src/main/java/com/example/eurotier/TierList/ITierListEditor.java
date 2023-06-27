package com.example.eurotier.TierList;

public interface ITierListEditor {
    TierReturnType addItem(Row row, String item);
    TierReturnType removeItem(Row row, String item);
    TierReturnType changeName(Row row, String name);
    TierReturnType commit(String eventType);
}
