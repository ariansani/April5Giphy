package vttp2022.nusiss.April5Giphy.models;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Giphy {
    private String title;
    private String id;
    private String imageUrl;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static List<Giphy> create(String json) throws IOException{
        List<Giphy> giphyList = new LinkedList<>();

        try(InputStream is = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8))){
            JsonReader r = Json.createReader(is);
            JsonObject o = r.readObject();
            JsonArray a = o.getJsonArray("data");
            a.stream()
            .map(v -> (JsonObject) v)
            .forEach((JsonObject v) -> {
               Giphy giphy = new Giphy();
                giphy.setId(v.getString("id"));
                giphy.setTitle(v.getString("title"));
                giphy.setImageUrl(v.getJsonObject("images").getJsonObject("original").getString("url"));
                giphyList.add(giphy);
            });
            
        }



        return giphyList;
    }
    
}
