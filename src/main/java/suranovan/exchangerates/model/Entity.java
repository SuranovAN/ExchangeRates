package suranovan.exchangerates.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Entity {
    @JsonProperty("ID")
    public String iD;
    @JsonProperty("NumCode")
    public String numCode;
    @JsonProperty("CharCode")
    public String charCode;
    @JsonProperty("Nominal")
    public int nominal;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("Value")
    public double value;
    @JsonProperty("Previous")
    public double previous;

    public Entity() {

    }

    public String getiD() {
        return iD;
    }

    public String getNumCode() {
        return numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public double getPrevious() {
        return previous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return nominal == entity.nominal && Double.compare(entity.value, value) == 0 && Double.compare(entity.previous, previous) == 0 && Objects.equals(iD, entity.iD) && Objects.equals(numCode, entity.numCode) && Objects.equals(charCode, entity.charCode) && Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iD, numCode, charCode, nominal, name, value, previous);
    }

    @Override
    public String toString() {
        return "iD='" + iD + '\'' +
                ", numCode='" + numCode + '\'' +
                ", charCode='" + charCode + '\'' +
                ", nominal=" + nominal +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", previous=" + previous;
    }
}
