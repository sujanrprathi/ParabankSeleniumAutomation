package test.parabank.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ConfigReader {

    File file = new File("src/main/config.json");
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node;
    public String url;
    public String browser;
    public int wait;

    public void setValues() {
        try {
            node=mapper.readTree(file);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        url = node.get("url").asText();
        browser = node.get("browser").asText();
        wait = node.get("wait").asInt();
    }
}


