package com.github.taojintianxia.incubator.test.multi;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import lombok.Getter;
import lombok.Setter;

/**
 * @author nianjun
 * 
 */

@Component("StatusProducer")
public class StatusProducer {

    private final Multimap<String, BuildingResult> buildingResultMap = ArrayListMultimap.create();

    private StatusProducer() {}

    private static StatusProducer INSTANCE = new StatusProducer();

    public static StatusProducer getInstance() {
        return INSTANCE;
    }

    @Getter
    @Setter
    public class BuildingResult {
        private String status;
    }

    public void putBuildingResult(String key, String result) {
        if (Strings.isNullOrEmpty(key) || Strings.isNullOrEmpty(result)) {
            return;
        }
        System.out.println(" putting " + key);

        synchronized (key) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Collection<BuildingResult> buildingResults = buildingResultMap.get(key);
            if (buildingResults == null || buildingResults.isEmpty()) {
                buildingResults = new ArrayList<>();
            }
            BuildingResult buildingResult = new BuildingResult();
            buildingResult.setStatus(result);
            buildingResults.add(buildingResult);
        }

        System.out.println(" putting " + key + "finished");
    }

    public Collection<BuildingResult> getBuildingResult(String key) {
        System.out.println(" getting " + key);
        if (Strings.isNullOrEmpty(key)) {
            return new ArrayList<>();
        }
        synchronized (key) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Collection<BuildingResult> buildingResults = new ArrayList<>();
            buildingResults.addAll(buildingResultMap.get(key));
            buildingResultMap.get(key).clear();
            System.out.println(" getting " + key + "finished");
            return buildingResults;
        }
    }

}
