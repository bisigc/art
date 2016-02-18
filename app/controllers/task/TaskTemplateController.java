package controllers.task;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.json.JSONObject;
import org.json.XML;

import controllers.AbstractCRUDController;
import dao.GenericDAO;
import models.task.TaskTemplate;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import utils.exceptions.ItemNotFoundException;
import utils.xml.XmlHelper;
import utils.xslfo.XslfoFromatter;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link TaskTemplate} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
@Singleton
public class TaskTemplateController extends AbstractCRUDController<TaskTemplate, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("TaskTemplateDAO")".
	 * 
	 * @param dao GenericDAO
	 */
	@Inject
	public TaskTemplateController(@Named("TaskTemplateDAO") GenericDAO<TaskTemplate, Long> dao) {
		super(dao);
	}

	/**
	 * Returns a TaskTemplate as a formatted PDF. First the methods loads the TaskTemplate
	 * Object from the DataSource and converts it to JSON and than it is converted
	 * to XML with the org.json library. Might be a little bit overhead but it seems to be
	 * the easier way than to annotate the Model Beans both with JSON and XML Object values.
	 * The xml than is formatted with Apache FOP (Helper Class {@link XslfoFromatter}.
	 * 
	 * @param id Primary key of the Smell which has to be formatted to a PDF
	 * @return HTTP result
	 */
	@Transactional(readOnly=true)
	public Result getPDF(Long id) {
		TaskTemplate task;
		byte [] pdfbytes;
		try {
			task = dao.get(id);
			String jsonString = Json.toJson(task).toString();
			JSONObject jsonobject = new JSONObject(jsonString);
			
			String requestUri =  "http://" + request().host() + "/#/task/" + task.getId();
			Logger.debug("Request URL: " + requestUri);

			StringBuffer xmlstringbuffer = new StringBuffer(XML.toString(jsonobject, "task"));
			int firstbracket = xmlstringbuffer.indexOf(">") + 1;
			xmlstringbuffer.insert(firstbracket, "<uri>" + requestUri + "</uri>");
			
			// remove the not needed homepage tag, which can contain unmasked special characters
			String xmlstring = XmlHelper.removeTag("homepage", xmlstringbuffer.toString());
			Logger.debug("XML-String to format: " + xmlstring);
			InputStream stream = new ByteArrayInputStream(xmlstring.getBytes(StandardCharsets.UTF_8));

			pdfbytes = XslfoFromatter.format(stream, "Task.xsl");
		} catch (ItemNotFoundException e) {
			Logger.error(e.getMessage(), e);
			return notFound(e.getMessage());
		} catch (Exception e) {
			String msg = "Failed to create PDF for " + dao.getModel().getSimpleName() + " with id " + id;
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		String filename = "task_" + id + ".pdf";
		response().setHeader("Content-Disposition", "attachment; filename=" + filename);
		return pdfbytes == null ? notFound() : ok(pdfbytes).as("application/pdf");
	}
	
}
