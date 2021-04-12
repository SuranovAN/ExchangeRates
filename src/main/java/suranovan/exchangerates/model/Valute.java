package suranovan.exchangerates.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Valute {

    @JsonProperty("Valute")
    private Map<String, Entity> entityMap;

    public Map<String, Entity> getEntityMap() {
        return entityMap;
    }

    @Override
    public String toString() {
        return "entityList=" + entityMap;
    }
}
