package com.mutants.enumerator;

import com.mutants.v2.analyzer.DiagonalAnalyzerV2;
import com.mutants.v2.analyzer.HorizontalAnalyzerV2;
import com.mutants.v2.analyzer.InvertedDiagonalAnalyzerV2;
import com.mutants.v2.analyzer.LineAnalyzerV2;
import com.mutants.v2.analyzer.VerticalAnalyzerV2;

/**
 * Represents each analyzer in the V2 algorithm
 * 
 * @author Pablo
 *
 */
public enum LineAnalyzerV2Type {
	
	HORIZONTAL_ANALYZER(new HorizontalAnalyzerV2()),
	VERTICAL_ANALYZER(new VerticalAnalyzerV2()),
	DIAGONAL_ANALYZER(new DiagonalAnalyzerV2()),
	INVERTED_DIAGONAL_ANALYZER(new InvertedDiagonalAnalyzerV2());
	
	
	private LineAnalyzerV2 lineAnalyzer;

	private LineAnalyzerV2Type(LineAnalyzerV2 lineAnalyzer) {
		this.lineAnalyzer = lineAnalyzer;
	}

	public LineAnalyzerV2 getLineAnalyzer() {
		return lineAnalyzer;
	}

}
