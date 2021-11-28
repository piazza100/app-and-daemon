package com.piazza.app.exception;

import java.util.Map;

import lombok.Data;

@Data
public class AppException extends RuntimeException {
	private static final long serialVersionUID = -4428883185317881260L;

	private AppException.Code code;
    private Map<String, Object> errorVO;

	public AppException(AppException.Code code) {
		this.code = code;
	}

	public AppException(AppException.Code code, Map<String, Object> errorVO) {
		this.code = code;
		this.errorVO = errorVO;
	}
	
	public enum Code {
		SUCCESS("E0000", "성공"),
		EXCEPTION("E1000", "에러"),
		;

		private String key;
		private String value;

		Code(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		AppException.Code success = AppException.Code.SUCCESS;
		System.out.println(success.getKey());
		System.out.println(success.getValue());
	}

}
