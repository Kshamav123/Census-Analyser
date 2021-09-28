package com.censusanalyzertest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.censusanalyser.CensusAnalyzerException;
import com.censusanalyser.StateCensusAnalyzer;

public class StateCensusAnalyzerTest {
	String correctPath = "/Users/kshamavidyananda/eclipse-workspace/CensusAnalyser/data/censusspreadsheet.csv";
	String incorrectPath = "/Users/kshamavidyananda/eclipse-workspace/CensusAnalyser/data/census.csv";

	/**
	 *  test reading CSV file given correct file path
	 * 
	 * @throws IOException
	 * @throws CensusAnalyserException
	 */
	@Test
	public void givenCorrectFilePath_ReturnCountOfLines()
			throws IOException, CensusAnalyzerException {
		StateCensusAnalyzer stateCensusAnalyser = new StateCensusAnalyzer();
		stateCensusAnalyser.loadCSV(correctPath);
		int lines = stateCensusAnalyser.countingLines(correctPath);
		Assert.assertEquals(5, lines);
	}

	/**
	 * test reading csv file given incorrect file path
	 */
	@Test
	public void givenIncorrectFilePath_ShouldThrow_CustomException() {
		StateCensusAnalyzer stateCensusAnalyser = new StateCensusAnalyzer();
		try {
			stateCensusAnalyser.loadCSV(incorrectPath);
		} catch (IOException e) {
			Assert.assertEquals("please check file path", e.getMessage());
		} catch (CensusAnalyzerException e) {
			Assert.assertEquals("please check file path", e.getMessage());
		}
	}
}
