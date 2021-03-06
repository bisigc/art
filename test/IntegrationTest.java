import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

import org.junit.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import play.libs.F.Callback;
import play.test.TestBrowser;

public class IntegrationTest {

    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     */
    @Test
    public void test() {
       // running(testServer(9086, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
        running(testServer(9086, fakeApplication(inMemoryDatabase())), new HtmlUnitDriver(), new Callback<TestBrowser>() {
            public void invoke(TestBrowser browser) {
                browser.goTo("http://localhost:9086");
                assertThat("Application ready?", browser.pageSource(), containsString("Architectural Refactoring Tool"));
            }
        });
    }

}
