package com.censusanalyser;

public class CensusAnalyzerException extends Exception{
	
	enum ExceptionType {
		ENTERED_INVALID_FILE, IO_EXCEPTION
	};

	ExceptionType type;

	public CensusAnalyzerException(ExceptionType type, String message) {
		super(message);
		this.type = type;
	}

}
