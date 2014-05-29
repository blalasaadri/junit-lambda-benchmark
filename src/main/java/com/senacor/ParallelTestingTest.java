package com.senacor;

import com.github.marschall.junitlambda.annotations.ParallelTesting;

/**
 * @author acollinson
 */
@ParallelTesting
public class ParallelTestingTest extends Tester {

    @Override
    protected String whoAmI() {
        return "parallel";
    }
}
