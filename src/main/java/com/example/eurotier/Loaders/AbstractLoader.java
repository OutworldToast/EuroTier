package com.example.eurotier.Loaders;

import com.example.eurotier.Flagger.Flagger;
import com.example.eurotier.Flagger.IFlagger;
import com.example.eurotier.TierList.TierList;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public abstract class AbstractLoader {

    public TierList load(File file) {
        Map<String, ArrayList<String>> source = parse(file);
        return generate(source);
    }

    public abstract Map<String, ArrayList<String>> parse(File file);
    public abstract TierList generate(Map<String, ArrayList<String>> source);
    public boolean validate(String key) {
        IFlagger flagger = new Flagger();
        return flagger.hasKey(key);
    }
}
