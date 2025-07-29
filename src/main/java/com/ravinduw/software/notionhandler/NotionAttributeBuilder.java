package com.ravinduw.software.notionhandler;

import org.json.JSONArray;
import org.json.JSONObject;

public class NotionAttributeBuilder {

    private final JSONObject propertiesObject;

    public NotionAttributeBuilder() {
        propertiesObject = new JSONObject();
    }

    public JSONObject getPropertiesObject() {
        return propertiesObject;
    }

    public void setTitle(String fieldName, String title) throws Exception {

        JSONObject titleObject = new JSONObject();

        titleObject.put("type", "title");
        titleObject.put("title", new JSONArray()
                .put(new JSONObject()
                        .put("type", "text")
                        .put("text", new JSONObject()
                                .put("content", title)
                        )
                )
        );

        propertiesObject.put(fieldName, titleObject);

    }

    public void setRichText(String fieldName, String richText) throws Exception {

        JSONObject rtObject = new JSONObject();

        rtObject.put("type", "rich_text");
        rtObject.put("rich_text", new JSONArray()
                .put(new JSONObject()
                        .put("type", "text")
                        .put("text", new JSONObject()
                                .put("content", richText)
                        )
                )
        );

        propertiesObject.put(fieldName, rtObject);

    }

}
