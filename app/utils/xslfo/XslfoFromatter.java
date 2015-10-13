package utils.xslfo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import play.Logger;
import play.Play;

public class XslfoFromatter {

	// The static Transformation factories which can be reused.
	private static FopFactory fopFactory = FopFactory.newInstance(new File("").toURI());
	private static TransformerFactory factory = TransformerFactory.newInstance();
	
	public static void main(String[] args) {
		InputStream xmlis = ClassLoader.getSystemResourceAsStream("Beispieldokument.xml");
		try {
			byte[] pdfbytes = format(xmlis, "ArVersion.xsl");
			FileOutputStream fos;
			fos = new FileOutputStream("Beispiel.pdf");
			fos.write(pdfbytes);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FOPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This static method receives an xml input stream and the filename of a XSL-Stylesheet.
	 * The stylesheet will be grabbed via the Classloader from the Classpath.
	 * 
	 * @param inputxml Input XML Stream to format
	 * @param stylesheetFilename Stylesheet name which can be found in the classpath
	 * @return PDF byte array
	 * @throws FOPException Exception in the FOP formatting
	 * @throws TransformerException Exception in either the XSLT or the Fop-Transformation
	 * @throws IOException Exception can occure when closing Streams fail.
	 */
	public static byte[] format(InputStream inputxml, String stylesheetFilename) throws FOPException, TransformerException, IOException {
		
		ByteArrayOutputStream xslfoByteArrayOS = new ByteArrayOutputStream();
		ByteArrayOutputStream pdfByteArrayOS = new ByteArrayOutputStream();

		// XSL-Transformation (Creating the XSL-FO with the Input XML and the XSL-Stylesheet)
		InputStream stylesheet = Play.application().classloader().getResourceAsStream(stylesheetFilename);
		Source xmlstream = new StreamSource(inputxml);
		Source xslt = new StreamSource(stylesheet);
		Result xslfores = new StreamResult(xslfoByteArrayOS);
		Transformer xsltTransformer = factory.newTransformer(xslt);
		xsltTransformer.transform(xmlstream, xslfores);
		
		Logger.debug("XSL-FO: " + new String(xslfoByteArrayOS.toByteArray()));

		// Formatting the XSL-FO file to a PDF
		Transformer foTransformer = factory.newTransformer();
		Fop fopPDF = fopFactory.newFop(MimeConstants.MIME_PDF, pdfByteArrayOS);
		Source src = new StreamSource(new ByteArrayInputStream(xslfoByteArrayOS.toByteArray()));
		Result res = new SAXResult(fopPDF.getDefaultHandler());
		foTransformer.transform(src, res);

		pdfByteArrayOS.close();
		xslfoByteArrayOS.close();

		return pdfByteArrayOS.toByteArray();
	}

}
