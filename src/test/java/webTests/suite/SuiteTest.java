package webTests.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import webTests.TestDelete;
import webTests.TestGet;
import webTests.TestPost;
import webTests.TestPut;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        TestGet.class,
        TestPost.class,
        TestDelete.class,
        TestPut.class,


})

public class SuiteTest {
}
