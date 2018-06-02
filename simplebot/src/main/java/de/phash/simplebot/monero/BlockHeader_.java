
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
    "block_size",
    "depth",
    "difficulty",
    "hash",
    "height",
    "major_version",
    "minor_version",
    "nonce",
    "num_txes",
    "orphan_status",
    "prev_hash",
    "reward",
    "timestamp"
})
public class BlockHeader_ {

    @JsonProperty("block_size")
    private Long blockSize;
    @JsonProperty("depth")
    private Long depth;
    @JsonProperty("difficulty")
    private Long difficulty;
    @JsonProperty("hash")
    private String hash;
    @JsonProperty("height")
    private Long height;
    @JsonProperty("major_version")
    private Long majorVersion;
    @JsonProperty("minor_version")
    private Long minorVersion;
    @JsonProperty("nonce")
    private Long nonce;
    @JsonProperty("num_txes")
    private Long numTxes;
    @JsonProperty("orphan_status")
    private Boolean orphanStatus;
    @JsonProperty("prev_hash")
    private String prevHash;
    @JsonProperty("reward")
    private Long reward;
    @JsonProperty("timestamp")
    private Long timestamp;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BlockHeader_() {
    }

    /**
     * 
     * @param timestamp
     * @param orphanStatus
     * @param majorVersion
     * @param height
     * @param reward
     * @param nonce
     * @param hash
     * @param numTxes
     * @param prevHash
     * @param minorVersion
     * @param difficulty
     * @param blockSize
     * @param depth
     */
    public BlockHeader_(Long blockSize, Long depth, Long difficulty, String hash, Long height, Long majorVersion, Long minorVersion, Long nonce, Long numTxes, Boolean orphanStatus, String prevHash, Long reward, Long timestamp) {
        super();
        this.blockSize = blockSize;
        this.depth = depth;
        this.difficulty = difficulty;
        this.hash = hash;
        this.height = height;
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.nonce = nonce;
        this.numTxes = numTxes;
        this.orphanStatus = orphanStatus;
        this.prevHash = prevHash;
        this.reward = reward;
        this.timestamp = timestamp;
    }

    @JsonProperty("block_size")
    public Long getBlockSize() {
        return blockSize;
    }

    @JsonProperty("block_size")
    public void setBlockSize(Long blockSize) {
        this.blockSize = blockSize;
    }

    @JsonProperty("depth")
    public Long getDepth() {
        return depth;
    }

    @JsonProperty("depth")
    public void setDepth(Long depth) {
        this.depth = depth;
    }

    @JsonProperty("difficulty")
    public Long getDifficulty() {
        return difficulty;
    }

    @JsonProperty("difficulty")
    public void setDifficulty(Long difficulty) {
        this.difficulty = difficulty;
    }

    @JsonProperty("hash")
    public String getHash() {
        return hash;
    }

    @JsonProperty("hash")
    public void setHash(String hash) {
        this.hash = hash;
    }

    @JsonProperty("height")
    public Long getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Long height) {
        this.height = height;
    }

    @JsonProperty("major_version")
    public Long getMajorVersion() {
        return majorVersion;
    }

    @JsonProperty("major_version")
    public void setMajorVersion(Long majorVersion) {
        this.majorVersion = majorVersion;
    }

    @JsonProperty("minor_version")
    public Long getMinorVersion() {
        return minorVersion;
    }

    @JsonProperty("minor_version")
    public void setMinorVersion(Long minorVersion) {
        this.minorVersion = minorVersion;
    }

    @JsonProperty("nonce")
    public Long getNonce() {
        return nonce;
    }

    @JsonProperty("nonce")
    public void setNonce(Long nonce) {
        this.nonce = nonce;
    }

    @JsonProperty("num_txes")
    public Long getNumTxes() {
        return numTxes;
    }

    @JsonProperty("num_txes")
    public void setNumTxes(Long numTxes) {
        this.numTxes = numTxes;
    }

    @JsonProperty("orphan_status")
    public Boolean getOrphanStatus() {
        return orphanStatus;
    }

    @JsonProperty("orphan_status")
    public void setOrphanStatus(Boolean orphanStatus) {
        this.orphanStatus = orphanStatus;
    }

    @JsonProperty("prev_hash")
    public String getPrevHash() {
        return prevHash;
    }

    @JsonProperty("prev_hash")
    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }

    @JsonProperty("reward")
    public Long getReward() {
        return reward;
    }

    @JsonProperty("reward")
    public void setReward(Long reward) {
        this.reward = reward;
    }

    @JsonProperty("timestamp")
    public Long getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
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
