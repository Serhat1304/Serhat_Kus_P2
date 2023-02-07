package com.hemebiotech.analytics.Write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filepath;

    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void write(Map<String, Integer> diseases) {

        if(filepath != null) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));

                for (String key : diseases.keySet()) {
                    writer.write(key + " : " + diseases.get(key));
                    writer.newLine();
                }

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
