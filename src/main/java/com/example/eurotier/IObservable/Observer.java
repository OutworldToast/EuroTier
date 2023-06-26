package com.example.eurotier.IObservable;

import com.example.eurotier.TierList.TierList;

public interface Observer {
    public boolean push(TierList tierList);
    public String returnOnFailure();
}
