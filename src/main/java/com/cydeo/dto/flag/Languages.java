
package com.cydeo.dto.flag;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aym",
    "que",
    "spa"
})
@Generated("jsonschema2pojo")
public class Languages {

    @JsonProperty("aym")
    private String aym;
    @JsonProperty("que")
    private String que;
    @JsonProperty("spa")
    private String spa;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("aym")
    public String getAym() {
        return aym;
    }

    @JsonProperty("aym")
    public void setAym(String aym) {
        this.aym = aym;
    }

    @JsonProperty("que")
    public String getQue() {
        return que;
    }

    @JsonProperty("que")
    public void setQue(String que) {
        this.que = que;
    }

    @JsonProperty("spa")
    public String getSpa() {
        return spa;
    }

    @JsonProperty("spa")
    public void setSpa(String spa) {
        this.spa = spa;
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
