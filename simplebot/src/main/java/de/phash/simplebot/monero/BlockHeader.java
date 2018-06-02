
package de.phash.simplebot.monero;

import java.util.HashMap;
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
    "block_header",
    "status",
    "untrusted"
})
public class BlockHeader {

    @JsonProperty("block_header")
    @Valid
    private BlockHeader_ blockHeader;
    @JsonProperty("status")
    private String status;
    @JsonProperty("untrusted")
    private Boolean untrusted;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BlockHeader() {
    }

    /**
     * 
     * @param status
     * @param untrusted
     * @param blockHeader
     */
    public BlockHeader(BlockHeader_ blockHeader, String status, Boolean untrusted) {
        super();
        this.blockHeader = blockHeader;
        this.status = status;
        this.untrusted = untrusted;
    }

    @JsonProperty("block_header")
    public BlockHeader_ getBlockHeader() {
        return blockHeader;
    }

    @JsonProperty("block_header")
    public void setBlockHeader(BlockHeader_ blockHeader) {
        this.blockHeader = blockHeader;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("untrusted")
    public Boolean getUntrusted() {
        return untrusted;
    }

    @JsonProperty("untrusted")
    public void setUntrusted(Boolean untrusted) {
        this.untrusted = untrusted;
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
