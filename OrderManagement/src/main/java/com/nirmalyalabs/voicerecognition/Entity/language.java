package com.nirmalyalabs.voicerecognition.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lang_master")
public class language {
	
	@Id
	@Column(name="lang_code", nullable=false)
	private String langcode;
	@Column(name="lang_name", nullable=false)
	private String langname;
	@Column(name="lang_accent")
	private String langaccent;
	public String getLangcode() {
		return langcode;
	}
	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}
	public String getLangname() {
		return langname;
	}
	public void setLangname(String langname) {
		this.langname = langname;
	}
	public String getLangaccent() {
		return langaccent;
	}
	public void setLangaccent(String langaccent) {
		this.langaccent = langaccent;
	}
	
	

}
