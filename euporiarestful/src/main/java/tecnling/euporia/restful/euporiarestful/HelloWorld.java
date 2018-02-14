/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnling.euporia.restful.euporiarestful;

import org.json.JSONObject;
import tecnling.euporia.restful.euporiarestful.database.DatabaseOperations;
import tecnling.euporia.restful.euporiarestful.database.DocumentDAO;
import tecnling.euporia.restful.euporiarestful.documentmanagement.TextSearchingHelper;
import tecnling.euporia.restful.euporiarestful.utils.AppConstants;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.util.Iterator;

/**
 * REST Web Service
 *
 * @author alessio
 */
@Path("helloworld")
public class HelloWorld {

    @Context
    private UriInfo context;


    /**
     * Retrieves representation of an instance of tecnling.euporia.restful.euporiarestful.HelloWorld
     * @return an instance of java.lang.String
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDocument(){
        TextSearchingHelper textHelp = new TextSearchingHelper();
        Iterator<DocumentDAO> iterator = textHelp.getDocumentsByAuthor("car").iterator();
        return iterator.next().toJson().toString();
    }

    /**
     * PUT method for updating or creating an instance of HelloWorld
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
