package com.example.eurotier.Pushers;

import com.example.eurotier.IObservable.Observer;

public interface AbstractPusher extends Observer {
    @Override
    default String returnOnFailure() {
        return null;
    }
}
