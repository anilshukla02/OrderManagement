package com.nirmalyalabs.voicerecognition.Utilities.Mymemory;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {


    @JsonProperty("responseData")
    private ResponseData responseData;
    
    @JsonProperty("quotaFinished")
    private String quotaFinished;
    
    @JsonProperty("mtLangSupported")
    private String mtLangSupported;
    
    @JsonProperty("responseDetails")
    private String responseDetails;
    
    @JsonProperty("responseStatus")
    private int responseStatus;
    
    @JsonProperty("responderId")
    private int responderId;
    
    @JsonProperty("exception_code")
    private String exception_code;
    
    @JsonProperty("matches")
    private List<Match> matches;

    public ResponseData getResponseData() {
        return responseData;
    }

    public String getResponseDetails() {
        return responseDetails;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public int getResponderId() {
        return responderId;
    }

	public String getQuotaFinished() {
		return quotaFinished;
	}

	public void setQuotaFinished(String quotaFinished) {
		this.quotaFinished = quotaFinished;
	}

	public String getMtLangSupported() {
		return mtLangSupported;
	}

	public void setMtLangSupported(String mtLangSupported) {
		this.mtLangSupported = mtLangSupported;
	}

	public String getException_code() {
		return exception_code;
	}

	public void setException_code(String exception_code) {
		this.exception_code = exception_code;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public void setResponseData(ResponseData responseData) {
		this.responseData = responseData;
	}

	public void setResponseDetails(String responseDetails) {
		this.responseDetails = responseDetails;
	}

	public void setResponseStatus(int responseStatus) {
		this.responseStatus = responseStatus;
	}

	public void setResponderId(int responderId) {
		this.responderId = responderId;
	}

	@Override
	public String toString() {
		return "Response [responseData=" + responseData + ", quotaFinished=" + quotaFinished + ", mtLangSupported="
				+ mtLangSupported + ", responseDetails=" + responseDetails + ", responseStatus=" + responseStatus
				+ ", responderId=" + responderId + ", exception_code=" + exception_code + ", matches=" + matches + "]";
	}
	
	
}
