package api.data;

import common.util.ObjectUtil;

public class ContentProgramImageMetaData {
	private String imageId ;
	
	private String mappingId ;
	
	private String imageType ;

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getMappingId() {
		return mappingId;
	}

	public void setMappingId(String mappingId) {
		this.mappingId = mappingId;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	
	@Override
	public String toString() {
		return ObjectUtil.changeObjValueToString(this);
	}
}
