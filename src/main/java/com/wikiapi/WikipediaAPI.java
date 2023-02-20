package com.wikiapi;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WikipediaAPI {

    private static final String BASE_URL = "https://en.wikipedia.org/w/api.php";
    private static final String ACTION = "query";
    private static final String FORMAT = "json";
    private static final int LIMIT = 1;

    private final OkHttpClient client;

    public WikipediaAPI() {
        this.client = new OkHttpClient();
    }

    public String getSummary(String topic) throws IOException {
        String query = String.format("action=%s&format=%s&prop=extracts&exintro&explaintext&titles=%s&redirects&formatversion=2&exsentences=%d", ACTION, FORMAT, topic, LIMIT);
        String url = String.format("%s?%s", BASE_URL, query);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String responseString = response.body().string();

        // Parse responseString to extract the summary
        // ...

        return responseString;
    }
}
