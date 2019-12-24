package com.mutants;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mutants.solver.MutantSolverV1Test;
import com.mutants.solver.MutantSolverV2Test;

/**
 * Suite test. Run all the test togheter
 * 
 * @author Pablo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class SuiteTest {

	@Test
	public void run() {
		JUnitCore.runClasses(MutantSolverV1Test.class, MutantSolverV2Test.class);
	}

}