package com.example.eurotier.IObservable;

import com.example.eurotier.TierList.TierList;

public interface Observer<T> {
    public boolean push(T t);
}
