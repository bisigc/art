import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;

import org.junit.Test;

import play.twirl.api.Content;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat("Integer Check", a, is(2));
    }

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("");
        assertThat("Content Type", contentType(html), is("text/html"));
        assertThat("Content Body Tag", contentAsString(html), containsString("<body"));
    }

}
