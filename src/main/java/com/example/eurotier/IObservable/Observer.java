package com.example.eurotier.IObservable;

import com.example.eurotier.TierList.TierList;

public interface Observer {
    public void push(TierList tierList);
}
