package com.nirmalyalabs.voicerecognition.Utilities.Mymemory;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Match {
	
	@JsonProperty("id")
    private long id;
	@JsonProperty("segment")
    private String segment;

    @JsonProperty("translation")
    private String translation;
    
    @JsonProperty("source")
    private String source;
    @JsonProperty("target")
    private String target;
    
    @JsonProperty("quality")
    private int quality;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("usage-count")
    private int usageCount;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("created-by")
    private String createdBy;
    @JsonProperty("last-updated-by")
    private String lastUpdateBy;
    
    @DateTimeFormat (pattern = "Yyyy-mm-dd HH:mm:ss")
    @JsonFormat (pattern = "Yyyy-mm-dd HH:mm:ss")
    @JsonProperty("create-date")
    private Date createDate;
    
    @DateTimeFormat (pattern = "Yyyy-mm-dd HH:mm:ss")
    @JsonFormat (pattern = "Yyyy-mm-dd HH:mm:ss")
    @JsonProperty("last-update-date")
    private Date lastUpdateDate;
    @JsonProperty("match")
    private double match;
    @JsonProperty("model")
    private String model;
	@Override
	public String toString() {
		return "Match [id=" + id + ", segment=" + segment + ", translation=" + translation + ", source=" + source
				+ ", target=" + target + ", quality=" + quality + ", reference=" + reference + ", usageCount="
				+ usageCount + ", subject=" + subject + ", createdBy=" + createdBy + ", lastUpdateBy=" + lastUpdateBy
				+ ", createDate=" + createDate + ", lastUpdateDate=" + lastUpdateDate + ", match=" + match + ", model="
				+ model + "]";
	}

    
    
}
