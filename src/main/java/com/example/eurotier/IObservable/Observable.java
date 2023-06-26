package com.example.eurotier.IObservable;

import com.example.eurotier.TierList.TierReturnType;

public interface Observable {

    public void addListener(Observer observer);
    public void removeListener(Observer observer);
    public void alert();

}
