package api.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import common.util.ObjectUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProgramProductData {
	private String programId ; 
	
	private String productId ; 
	
	private String title ;
	
	private String text ; 
	
	private String season ; 
	
	private String episode ;

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getEpisode() {
		return episode;
	}

	public void setEpisode(String episode) {
		this.episode = episode;
	} 
	
	@Override
	public String toString() {
		return ObjectUtil.changeObjValueToString(this);
	}
}
