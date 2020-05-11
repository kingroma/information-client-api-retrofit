package api.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import common.util.ObjectUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonData<T> {
	private String resultCode;

	private String resultMessage;

	private T result;

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
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

	@Override
	public String toString() {
		return ObjectUtil.changeObjValueToString(this);
	}
}
