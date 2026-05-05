package solutions.facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiFacade {

    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {

        String json = getJsonFromApi(urlString);
        return extractValue(json, attributeName);
    }

    // Handles HTTP request
    private String getJsonFromApi(String urlString) throws IOException {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );

            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            con.disconnect();

            return content.toString();

        } catch (Exception e) {
            throw new IOException("Error fetching data from API");
        }
    }

    // Handles JSON parsing
    private String extractValue(String json, String attributeName) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(json);

            if (!obj.containsKey(attributeName)) {
                throw new IllegalArgumentException("Attribute not found: " + attributeName);
            }

            return obj.get(attributeName).toString();

        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalArgumentException("Error parsing JSON");
        }
    }
}