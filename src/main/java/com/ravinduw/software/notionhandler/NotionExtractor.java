package com.ravinduw.software.notionhandler;

import org.json.JSONArray;
import org.json.JSONObject;

public class NotionExtractor {

    private final JSONObject properties;

    public NotionExtractor(JSONObject properties) throws Exception {

        this.properties = properties;

    }

    public String extractRichText(String key) throws Exception {

        JSONArray richTextArray = properties.getJSONObject(key).getJSONArray("rich_text");
        if (!richTextArray.isEmpty()) {
            return richTextArray.getJSONObject(0).getString("plain_text");
        }
        return "";

    }

    public String extractDate(String key) throws Exception {

        JSONObject dateObject = properties.getJSONObject(key).getJSONObject("date");
        return dateObject.getString("start");

    }

    public String extractSelect(String key) throws Exception {

        String returnChkVal = "";

        returnChkVal = properties.getJSONObject(key).getJSONObject("select").getString("name");

        if (!(returnChkVal.isEmpty())) {
            return returnChkVal;
        }

        return "";

    }

    public String extractStatus(String key) throws Exception {

        String returnChkVal = "";

        returnChkVal = properties.getJSONObject(key).getJSONObject("status").getString("name");

        if (!(returnChkVal.equals(""))) {
            return returnChkVal;
        }

        return "";

    }

    public String extractTitle(String key) throws Exception {

        String title;

        JSONArray titleArray = properties.getJSONObject(key).getJSONArray("title");
        JSONObject firstTitle = titleArray.getJSONObject(0);

        // JSONObject firstTitle = properties.getJSONObject(key).getJSONArray("title").getJSONObject(0);

        JSONObject textObject = firstTitle.getJSONObject("text");
        title = textObject.getString("content");

        if (!(title.isEmpty())) {
            return title;
        }

        return "";

    }

}
