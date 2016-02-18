package utils.xml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests the functionality of the {@link XmlHelper} class.
 * 
 * @author cbi
 */
public class XmlHelperTest {

	@Test
	public void xmlRemoveTagTest() {
		String tagname = "homepage";
		String xmlstring = "<arversion><uri>http://localhost:9085/#/ar/20</uri><editor><firstname>Christian</firstname><password>null</password><startpage>stay</startpage><role><name>Admin</name><description>ART Administrator</description><id>1</id></role><arsearches><result>null</result><search>{\"smellids\":[18,19,24,27]}</search><name>My Search</name><id>1</id></arsearches><created>1432626312000</created><organisation>HSR</organisation><modified>1432626312000</modified><id>1</id><email>cbisig@hsr.ch</email><lastname>Bisig</lastname><homepage>http://ch.linkedin.com/in/cbisig&testparam</homepage></editor><smells><keywords>bottleneck</keywords><created>1448571195000</created><tecdebtidx>hm</tecdebtidx><name>Bottleneck component</name><questions><question>Does a component or a part of your software system thwart the whole system?</question><id>55</id></questions><description><p>If multiple components or system parts are running on the same hardware or even on separate hardware, on part can thwart the rest of the system.&#160;</p></description><weight>2</weight><modified>1449648586000</modified><id>39</id><group><name>Performance</name><id>1</id></group><status>published</status></smells></arversion>";
		String desiredResult = "<arversion><uri>http://localhost:9085/#/ar/20</uri><editor><firstname>Christian</firstname><password>null</password><startpage>stay</startpage><role><name>Admin</name><description>ART Administrator</description><id>1</id></role><arsearches><result>null</result><search>{\"smellids\":[18,19,24,27]}</search><name>My Search</name><id>1</id></arsearches><created>1432626312000</created><organisation>HSR</organisation><modified>1432626312000</modified><id>1</id><email>cbisig@hsr.ch</email><lastname>Bisig</lastname></editor><smells><keywords>bottleneck</keywords><created>1448571195000</created><tecdebtidx>hm</tecdebtidx><name>Bottleneck component</name><questions><question>Does a component or a part of your software system thwart the whole system?</question><id>55</id></questions><description><p>If multiple components or system parts are running on the same hardware or even on separate hardware, on part can thwart the rest of the system.&#160;</p></description><weight>2</weight><modified>1449648586000</modified><id>39</id><group><name>Performance</name><id>1</id></group><status>published</status></smells></arversion>";

		assertEquals(desiredResult, XmlHelper.removeTag(tagname, xmlstring));
	}
}
