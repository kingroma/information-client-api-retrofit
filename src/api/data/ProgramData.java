package api.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import common.util.ObjectUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProgramData {
	private String programId ; 
	
	private String title ; 
	
	private String synopsis ; 
	
	private String programType ; 
	
	private List<String> genres ;
	
	private List<ProgramProductData> products;

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getProgramType() {
		return programType;
	}

	public void setProgramType(String programType) {
		this.programType = programType;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<ProgramProductData> getProducts() {
		return products;
	}

	public void setProducts(List<ProgramProductData> products) {
		this.products = products;
	}
	
	@Override
	public String toString() {
		return ObjectUtil.changeObjValueToString(this);
	}
}
