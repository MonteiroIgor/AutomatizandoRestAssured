package webTests.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import webTests.TestDelete;
import webTests.TestGet;
import webTests.TestPost;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        TestGet.class,
        TestPost.class,
        TestDelete.class,


})

public class SuiteTest {
}
