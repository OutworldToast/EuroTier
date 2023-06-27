package com.example.eurotier.TierList;

import com.example.eurotier.IObservable.Observable;
import com.example.eurotier.IObservable.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EventManager implements Observable {

    private final Map<String, ArrayList<Observer>> listeners = new HashMap<>();

    @Override
    public Map<String, ArrayList<Observer>> getListeners() {
        return listeners;
    }
    @Override
    public void addListener(Observer observer, String eventType) {
        ArrayList<Observer> pushers = listeners.get(eventType);
        if (pushers == null) {
            listeners.put(eventType, new ArrayList<>());
            pushers = listeners.get(eventType);
        }
        pushers.add(observer);
    }

    @Override
    public void removeListener(Observer observer, String eventType) {
        ArrayList<Observer> pushers = listeners.get(eventType);
        if (pushers != null) {
            pushers.remove(observer);
        }
    }

    @Override
    public void alert(String eventType, Object toBePushed) {
        ArrayList<Observer> pushers = listeners.get(eventType);
        if (pushers != null) {
            for (Observer observer : pushers) {
                observer.push((TierList) toBePushed);
            }
        }
    }

}
