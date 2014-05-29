package com.senacor;

import com.github.marschall.junitlambda.runner.Java8JUnitTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Tests to determine whether the parallel testing works as intended.
 *
 * @author Alasdair Collinson
 */
@RunWith(Java8JUnitTestRunner.class)
public abstract class Tester {
    private static final Logger LOG = LoggerFactory.getLogger(Tester.class);

    private static Set<Integer> testsRun = new HashSet<>();

    private static Object lock = new Object();

    private static int testsInParallel = 0;

    private static void addTestRunning() {
        synchronized (lock) {
            testsInParallel++;
        }
    }

    private static void oneTestDone() {
        synchronized (lock) {
            testsInParallel--;
        }
    }

    private static int testsRunningNow() {
        synchronized (lock) {
            return testsInParallel;
        }
    }

    private static synchronized boolean canMarkAsDone(int i) {
        if (testsRun.contains(i)) {
            return false;
        } else {
            testsRun.add(i);
            return true;
        }
    }

    @Test
    public void test1() {
        test(1);
    }

    @Test
    public void test2() {
        test(2);
    }

    @Test
    public void test3() {
        test(3);
    }

    @Test
    public void test4() {
        test(4);
    }

    private void test(int number) {
        LOG.trace("Test {} starting", number);
        addTestRunning();
        for (long i = 0; i < number * 1000000000l; i++) {
            Math.sqrt(i);
            if (i % 500000000l == 0) {
                LOG.info(String.format("%s: test number %d, iteration %d, currently running %d test(s)", whoAmI(), number, i, testsRunningNow()));
            }
        }
        oneTestDone();
        LOG.trace("Test {} ending", number);
    }

    protected abstract String whoAmI();
}
