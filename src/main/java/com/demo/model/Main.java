
package com.demo.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "temp",
    "pressure",
    "humidity",
    "temp_min",
    "temp_max"
})
public class Main {

    @JsonProperty("temp")
    private String temp;
    @JsonProperty("pressure")
    private String pressure;
    @JsonProperty("humidity")
    private String humidity;
    @JsonProperty("temp_min")
    private String tempMin;
    @JsonProperty("temp_max")
    private String tempMax;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("temp")
    public String getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(String temp) {
        this.temp = temp;
    }

    @JsonProperty("pressure")
    public String getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("humidity")
    public String getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("temp_min")
    public String getTempMin() {
        return tempMin;
    }

    @JsonProperty("temp_min")
    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    @JsonProperty("temp_max")
    public String getTempMax() {
        return tempMax;
    }

    @JsonProperty("temp_max")
    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
