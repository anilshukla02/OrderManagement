package com.nirmalyalabs.voicerecognition.Utilities.Mymemory;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseData {

	    @JsonProperty("translatedText")
	    private String translatedText;
	    @JsonProperty("match")
	    private double match;

	    public String getTranslatedText() {
	        return translatedText;
	    }

	    public double getMatch() {
	        return match;
	    }

		@Override
		public String toString() {
			return "ResponseData [translatedText=" + translatedText + ", match=" + match + "]";
		}
	    
	
}
