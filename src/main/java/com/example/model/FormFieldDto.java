package com.example.model;

public class FormFieldDto {

	private String fieldName;
	private String errorMsg;

	public String getFieldName() {
		return fieldName;
	}

	public FormFieldDto(String fieldName, String errorMsg) {
		this.fieldName = fieldName;
		this.errorMsg = errorMsg;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "FormFieldDto [fieldName=" + fieldName + ", errorMsg=" + errorMsg + "]";
	}

}
