package recursos;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;

import servicios.PuntoServicio;
import modelos.Punto;

@Path("/rutas")
public class PuntoRecurso {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;
	
	PuntoServicio puntoServicio;
	public PuntoRecurso() {
		puntoServicio = new PuntoServicio();
	}
	public PuntoRecurso(UriInfo uriInfo2, Request request2, String id2) {
		this.uriInfo = uriInfo2;
		this.request = request2;
		this.id = id2;
		puntoServicio = new PuntoServicio();
	}
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Punto> getPuntos() {
		return PuntoServicio.getPuntoAsList();
	}
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Punto> getPuntosAsHtml() {
		return puntoServicio.getPuntoAsList();
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		return String.valueOf(puntoServicio.getPuntosCount());
	}
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createPunto(@FormParam("id") String id,
	@FormParam("latitud") String latitud,
	@FormParam("longitud") String longitud,
	@Context HttpServletResponse servletResponse)
	throws IOException {
		Punto punto = new Punto(id, latitud, longitud);
		puntoServicio.createPunto(punto);
		servletResponse.sendRedirect("./puntos/");
	}
	
	@Path("{punto}")	
	public PuntoRecurso getPunto(@PathParam("punto") String id) {
		return new PuntoRecurso(uriInfo, request, id);
	}
	
	@GET
	 @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	 public Punto getPunto() {
		Punto punto = puntoServicio.getPunto(id);
	 	return punto;
	 }
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Punto getPuntoAsHtml() {
		Punto punto = puntoServicio.getPunto(id);
		return punto;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putPunto(JAXBElement<Punto> puntoElement) {
		Punto punto = puntoElement.getValue();
		Response response;
		if (puntoServicio.getPuntos().containsKey(punto.getId())) {
			response = Response.noContent().build();
		} else {
			response = Response.created(uriInfo.getAbsolutePath()).build();
		}
		puntoServicio.createPunto(punto);
		return response;
	}

	@DELETE
	public void deletePunto() {
		puntoServicio.deletePunto(id);
	}

}
