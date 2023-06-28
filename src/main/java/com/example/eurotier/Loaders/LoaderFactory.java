package com.example.eurotier.Loaders;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class LoaderFactory {

    private final Map<String, AbstractLoader> loaders = new HashMap<>();

    public LoaderFactory() {
        //TODO: consider better way of initialising loaders
        loaders.put("csv", new CSVLoader());
        loaders.put("xlsx", new ExcelLoader());
    }

    public AbstractLoader createLoader(File file){
        String extension = getExtension(file);
        if (extension == null) {
            //TODO: consider if this is a good idea
            return null;
        } else {
            return loaders.get(extension);
        }

    }

    private String getExtension(File file) {

        String fileName = file.getName();
        int index = fileName.lastIndexOf('.');

        return index != -1 ? fileName.substring(index + 1) : null;

    }

}
