package com.mutants.enumerator;

import com.mutants.v1.analyzer.DiagonalLowerAnalyzerV1;
import com.mutants.v1.analyzer.DiagonalUpperAnalyzerV1;
import com.mutants.v1.analyzer.HorizontalAnalyzerV1;
import com.mutants.v1.analyzer.InvertedDiagonalLowerAnalyzerV1;
import com.mutants.v1.analyzer.InvertedDiagonalUpperAnalyzerV1;
import com.mutants.v1.analyzer.LineAnalyzerV1;
import com.mutants.v1.analyzer.VerticalAnalyzerV1;

/**
 * Represents each analyzer in the V1 algorithm
 * 
 * @author Pablo
 *
 */
public enum LineAnalyzerV1Type {

	HORIZONTAL_ANALYZER(new HorizontalAnalyzerV1()),
	VERTICAL_ANALYZER(new VerticalAnalyzerV1()),
	DIAGONAL_UPPER_ANALYZER(new DiagonalUpperAnalyzerV1()),
	DIAGONAL_LOWER_ANALYZER(new DiagonalLowerAnalyzerV1()),
	INVERTED_DIAGONAL_UPPER_ANALYZER(new InvertedDiagonalUpperAnalyzerV1()),
	INVERTED_DIAGONAL_LOWER_ANALYZER(new InvertedDiagonalLowerAnalyzerV1());
	
	
	private LineAnalyzerV1 lineAnalyzer;

	private LineAnalyzerV1Type(LineAnalyzerV1 lineAnalyzer) {
		this.lineAnalyzer = lineAnalyzer;
	}

	public LineAnalyzerV1 getLineAnalyzer() {
		return lineAnalyzer;
	}

	public void setLineAnalyzer(LineAnalyzerV1 lineAnalyzer) {
		this.lineAnalyzer = lineAnalyzer;
	}



}
