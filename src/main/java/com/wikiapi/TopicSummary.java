package com.wikiapi;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TopicSummary {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("There has to be only 1 argument for the topic you want to search");
        }
        WikipediaAPI wikiApi = new WikipediaAPI();
        FileWriter responseFile = new FileWriter("wikiResponse.json");
        Gson gson = new Gson();
        String response = wikiApi.getSummary("Oman");

        Map<String, Object> mainResponse = new HashMap<>();
        mainResponse = gson.fromJson(response, mainResponse.getClass());
        Map<String, Object> query = (Map<String, Object>) mainResponse.get("query");
        ArrayList<Object> pages = (ArrayList<Object>) query.get("pages");
        Map<String, Object> pagesArray = (Map<String, Object>) pages.get(0);
        String extract = (String) pagesArray.get("extract");

        System.out.println(extract);
        responseFile.write(extract);
        responseFile.flush();
        responseFile.close();

    }
}
