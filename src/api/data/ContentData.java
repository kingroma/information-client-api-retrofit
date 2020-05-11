package api.data;

import java.util.List;

import common.util.ObjectUtil;

public class ContentData {
	public enum ContentType {
		contentTop, contentBasic, contentIssue
	}

	private String contentId;

	private String contentName;

	private ContentType contentType;

	private List<ContentProgramData> list;

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	public List<ContentProgramData> getList() {
		return list;
	}

	public void setList(List<ContentProgramData> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return ObjectUtil.changeObjValueToString(this);
	}
}
