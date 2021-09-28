package com.censusanalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class StateCensusAnalyzer {
	public void loadCSV(String path) throws IOException, CensusAnalyzerException {
		try {
			Files.lines(new File(path).toPath()).forEach(System.out::println);
		} catch (FileNotFoundException e) {
			throw new CensusAnalyzerException(CensusAnalyzerException.ExceptionType.ENTERED_INVALID_FILE,
					"please check file path");
		} catch (IOException e) {
			throw new CensusAnalyzerException(CensusAnalyzerException.ExceptionType.IO_EXCEPTION,
					"please check file path");
		}
	}

	public int countingLines(String path) throws IOException {
		int entries = 0;
		entries = (int) Files.lines(new File(path).toPath()).count();
		return entries;
	}
}
