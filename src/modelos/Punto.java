package modelos;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Punto {

	private String id;
	private String latitud;
	private String longitud;
	
	public Punto() {
		
	}
	
	public Punto(String i, String la, String lo){
		this.id = i;
		this.latitud = la;
		this.longitud = lo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	@Provider
	public class DebugExceptionMapper implements ExceptionMapper<Exception> {

	    @Override
	    public Response toResponse(Exception exception) {
	        exception.printStackTrace();
	        return Response.serverError().entity(exception.getMessage()).build();
	    } 
	}
}


