package com.example.eurotier.TierList;

import com.example.eurotier.IObservable.Observable;
import com.example.eurotier.IObservable.Observer;
import com.example.eurotier.Pushers.MockPusher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EventManager implements Observable<TierList> {

    private final Map<String, ArrayList<Observer<TierList>>> listeners = new HashMap<>();

    @Override
    public Map<String, ArrayList<Observer<TierList>>> getListeners() {
        return listeners;
    }
    @Override
    public void addListener(Observer<TierList> observer, String eventType) {
        ArrayList<Observer<TierList>> pushers = listeners.get(eventType);
        if (pushers == null) {
            listeners.put(eventType, new ArrayList<>());
            pushers = listeners.get(eventType);
        }
        pushers.add(observer);
    }

    @Override
    public void removeListener(Observer<TierList> observer, String eventType) {
        ArrayList<Observer<TierList>> pushers = listeners.get(eventType);
        if (pushers != null) {
            pushers.remove(observer);
        }
    }

    @Override
    public void alert(String eventType, TierList toBePushed) {
        ArrayList<Observer<TierList>> pushers = listeners.get(eventType);
        if (pushers != null) {
            for (Observer<TierList> observer : pushers) {
                observer.push(toBePushed);
            }
        }
    }

}
