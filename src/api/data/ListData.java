package api.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import common.util.ObjectUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListData<T> {
	private String resultCode;

	private String resultMessage;

	private Integer totalCount;

	private List<T> result;

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return ObjectUtil.changeObjValueToString(this);
	}
}
