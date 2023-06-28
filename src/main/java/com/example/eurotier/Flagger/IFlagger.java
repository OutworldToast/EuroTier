package com.example.eurotier.Flagger;

import java.util.Set;

public interface IFlagger {

    String getValue(String key);
    Set<String> getKeySet();
    boolean hasKey(String key);
}
