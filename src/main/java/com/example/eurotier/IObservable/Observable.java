package com.example.eurotier.IObservable;

import java.util.ArrayList;
import java.util.Map;

public interface Observable {

    Map<String, ArrayList<Observer>> getListeners();
    void addListener(Observer observer, String eventType);
    void removeListener(Observer observer, String eventType);
    void alert(String eventType, Object toBePushed);
}
