package com.linkedin.android.testbutler.demo;

import android.support.test.rule.ActivityTestRule;

import com.linkedin.android.testbutler.TestButler;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by TimKist on 09/06/2017.
 */
public class ExampleBeforeAfterClassTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @BeforeClass
    public static void setUpClass() throws Exception {
        /*
         * If Test Butler apk not installed, it fails but test runner doesn't pick up exception "ButlerService is not started!".
         * See https://issuetracker.google.com/issues/37057596
         */
        TestButler.setGsmState(false);
    }

    @Test
    public void example() throws Exception {
        assertTrue(2 + 2 ==  4);
    }

    @AfterClass
    public static void tearDown() {
        TestButler.setGsmState(true);
    }
}
