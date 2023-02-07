package com.hemebiotech.analytics.Counter;

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
            /* Pour chaque maladie :
                    - s'il n'existe pas dans result, on ajoute la maladie comme clé, et 1 comme valeur
                    - sinon on remplace la maladie trouvée dans result et on ajoute + 1 à la valeur
             */
            diseases.forEach(disease -> result.put(disease, result.getOrDefault(disease, 0) + 1));
        }

        return result;
    }
}
