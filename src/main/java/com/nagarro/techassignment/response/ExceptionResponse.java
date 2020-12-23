package com.nagarro.techassignment.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;


public class ExceptionResponse {

	private String errorMessage;
    private String errorCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private List<ErrorModel> subErrorMessages;
    
    public ExceptionResponse(List<ErrorModel> subErrorMessages) {
		this.subErrorMessages=subErrorMessages;
	}

    public ExceptionResponse() {
		
	}

	public List<ErrorModel> getSubErrorMessages() {
		return subErrorMessages;
	}


	public void setSubErrorMessages(List<ErrorModel> subErrorMessages) {
		this.subErrorMessages = subErrorMessages;
	}
	public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
