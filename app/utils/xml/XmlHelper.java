package utils.xml;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * XmlHelper class, contains static methods for XML String manipulation.
 * 
 * @author cbi
 */
public class XmlHelper {
	
	/**
	 * A static threadsafe map which contains compiled Regex Patterns.
	 */
	private static Map<String, Pattern> patterns = new ConcurrentHashMap<String, Pattern>();

	/**
	 * Replaces a tag given by a tagname in an xmlstring.
	 * 
	 * @param tagname Name of the tag to be removed
	 * @param xmlstring XmlString to be modified
	 * @return modified XmlString
	 */
	public static String removeTag(String tagname, String xmlstring) {
		if(!patterns.containsKey(tagname)) { 
			String regex = "(\\<" + tagname + ">.+?\\</" + tagname + ">)";
		    Pattern pattern = Pattern.compile(regex, Pattern.DOTALL | Pattern.MULTILINE);
		    patterns.put(tagname, pattern);
		}
		
	    Matcher matcher = patterns.get(tagname).matcher(xmlstring);
	    if (matcher.find()) {
	    	xmlstring = matcher.replaceAll("");
	    }
	    
	    return xmlstring;
	}
	
}
