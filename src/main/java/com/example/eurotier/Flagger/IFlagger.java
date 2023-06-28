package com.example.eurotier.Flagger;


import java.util.ArrayList;

public interface IFlagger {

    String getValue(String key);
    ArrayList<String> getKeySet();
    boolean hasKey(String key);
}
