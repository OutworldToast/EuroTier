package com.example.eurotier.Flagger;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Flagger implements IFlagger{

    private Map<String, String> flagSet;

    public Flagger() {

        String filePath = createFilePath();
        if (filePath != null) {
            flagSet = createFlagSet(new File(filePath));
        } else {
            System.out.println("Houston, we have a problem");
            //TODO: consider options
        }
    }

    //useful for possible extension
    //override this method with a different filepath for new types of flaggers
    public String createFilePath() {
        return null;
    }

    public Map<String, String> createFlagSet(File file) {
        return null;
    }

    @Override
    public String getValue(String key) {
        return null;
    }

    @Override
    public ArrayList<String> getKeySet() {
        return null;
    }

    @Override
    public boolean hasKey(String key) {
        return false;
    }
}
