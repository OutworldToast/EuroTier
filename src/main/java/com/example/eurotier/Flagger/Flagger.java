package com.example.eurotier.Flagger;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Flagger implements IFlagger{

    private Map<String, String> flagSet = new HashMap<>();

    public Flagger() {
        this(false);
    }

    public Flagger(boolean isCustom) {
        if (!isCustom) {

            String fileName = createFileName();

            try {
                URL url = getClass().getResource(fileName);
                File file = new File(Objects.requireNonNull(url).getPath());
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
        return "flags.txt";
    }

    public Map<String, String> createFlagSet(File file) {

        Map<String, String> result = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {

            String key;
            do {
                key = reader.readLine();
                String value = "flags/Flag" + key + ".png";

                result.put(key, value);
            } while (key != null && !key.equals(""));

        } catch (Exception e) {
            result.put("NOTEXISTS", "No flag file found");
        }

        return result;
    }

    @Override
    public String getValue(String key) {
        return flagSet.get(key);
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
