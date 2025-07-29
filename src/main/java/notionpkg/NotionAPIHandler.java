package notionpkg;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NotionAPIHandler {

    private final String notionPageID;
    private final String notionVersion;
    private final String notionAPIKey;
    private final String notionURL = "https://api.notion.com/v1/pages/";

    public NotionAPIHandler(String notionPageID, String notionAPIKey) throws Exception {

        this.notionPageID = notionPageID;
        notionVersion = System.getenv("notionVersion");

        this.notionAPIKey = notionAPIKey;

    }

    public void updateNotion(NotionAttributeBuilder notionAttributes) throws Exception {

        String notionAPIURL = notionURL + notionPageID;

        JSONObject propertiesObject = notionAttributes.getPropertiesObject();

        try {

            JSONObject updateObject = new JSONObject();

            updateObject.put("properties", propertiesObject);

            HttpClient client = HttpClient.newHttpClient();

            // Build HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(notionAPIURL))
                    .header("Authorization", "Bearer " + notionAPIKey)
                    .header("Content-Type", "application/json")
                    .header("Notion-Version", notionVersion)
                    .method("PATCH", HttpRequest.BodyPublishers.ofString(updateObject.toString()))
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Handle the response
            if (response.statusCode() == 200) {
                System.out.println("Notion updated successfully.");
            } else {
                System.out.println("Failed to update notion. Response code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
