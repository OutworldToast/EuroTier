package com.example.eurotier.IObservable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface Observable<T> {

    Map<String, ArrayList<Observer<T>>> getListeners();
    void addListener(Observer<T> observer, String eventType);
    void removeListener(Observer<T> observer, String eventType);
    void alert(String eventType, T toBePushed);
}
