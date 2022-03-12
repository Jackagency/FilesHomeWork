package domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {
    public String name;
    public String surname;
    @JsonProperty("favorite_music")
    public List<String> favoriteMusic;
    public Address address;
}
