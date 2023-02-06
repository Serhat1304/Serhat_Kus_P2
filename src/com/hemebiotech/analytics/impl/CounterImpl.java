package com.hemebiotech.analytics.impl;

import com.hemebiotech.analytics.ICounter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CounterImpl implements ICounter {

    private final List<String> diseases;

    public CounterImpl(List<String> diseases) {
        this.diseases = diseases;
    }

    @Override
    public Map<String, Integer> countDiseases() {
        Map<String, Integer> result = new TreeMap<>();

        if(diseases != null) {
            diseases.forEach(disease -> result.put(disease, result.getOrDefault(disease, 0) + 1));
        }

        return result;
    }
}
