
package de.phash.simplebot.stocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "success",
    "result"
})
public class Trades {

    @JsonProperty("success")
    private Long success;
    @JsonProperty("result")
    @Valid
    private List<Result> result = new ArrayList<Result>();
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Trades() {
    }

    /**
     * 
     * @param result
     * @param success
     */
    public Trades(Long success, List<Result> result) {
        super();
        this.success = success;
        this.result = result;
    }

    @JsonProperty("success")
    public Long getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Long success) {
        this.success = success;
    }

    @JsonProperty("result")
    public List<Result> getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(List<Result> result) {
        this.result = result;
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
