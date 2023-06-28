package com.example.eurotier.Flagger;

import java.io.File;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Flagger implements IFlagger{

    private Map<String, String> flagSet;

    public Flagger() {
        this(false);
    }

    public Flagger(boolean isCustom) {
        if (!isCustom) {
            String fileName = createFileName();

            try {
                ClassLoader classLoader = getClass().getClassLoader();
                File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
                flagSet = createFlagSet(file);
            } catch (NullPointerException e) {
                System.out.println("Houston, we have a problem");
                //TODO: consider options
            }
        }
    }

    public Map<String, String> getFlagSet() {
        return flagSet;
    }

    //useful for possible extension
    //override this method with a different filepath for new types of flaggers
    public String createFileName() {
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
    public Set<String> getKeySet() {
        return flagSet.keySet();
    }

    @Override
    public boolean hasKey(String key) {
        return flagSet.containsKey(key);
    }
}
