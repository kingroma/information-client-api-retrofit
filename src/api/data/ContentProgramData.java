package api.data;

import java.util.List;

import common.util.ObjectUtil;

public class ContentProgramData {
	private String programId;

	private String title;

	private List<ContentProgramImageMetaData> imageMeta;

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

	public List<ContentProgramImageMetaData> getImageMeta() {
		return imageMeta;
	}

	public void setImageMeta(List<ContentProgramImageMetaData> imageMeta) {
		this.imageMeta = imageMeta;
	}

	@Override
	public String toString() {
		return ObjectUtil.changeObjValueToString(this);
	}
}
