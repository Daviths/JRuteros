package controladores;

import java.io.IOException;
import java.sql.*;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginUsr
 */
//@WebServlet("/LoginUsr")
@WebServlet(
		urlPatterns = { "/LoginUsr" }, 
		initParams = { 
				@WebInitParam(name = "Roman", value = "Asereje"), 
				@WebInitParam(name = "Admin", value = "1234"), 
		})
public class LoginUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ServletConfig sc;
	private String usuario, password;
	private Hashtable<String, String> logins;
	
	private Connection coneccion = null;
	private Statement declaracion = null;
	private ResultSet resultados = null;
	
    public LoginUsr() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		sc = config;
		logins = new Hashtable<String, String>();	
		try{
			 Class.forName("com.mysql.jdbc.Driver");		
			 try {
				coneccion = DriverManager.getConnection("jdbc:mysql://localhost/jruteros","root","gaspar");
				System.out.println("CONECTADO A LA BD");
			} catch (Exception e) {
				e.printStackTrace();
				//response.getWriter().append("Fallo la coneccion.");
			}
			 declaracion = coneccion.createStatement();
			 resultados = declaracion.executeQuery("SELECT * FROM jruteros.usuarios");
			 
			 if(resultados != null){
				 while(resultados.next()){
					 usuario = resultados.getString("usuario");					 
					 password = resultados.getString("password");
					 logins.put(usuario, password);
					 //response.getWriter().append("User:"+usuario+"|Pass:"+password+"<br>");
				 }
			 }
			 
		}catch(Exception e){
			e.printStackTrace();
			//response.getWriter().append("Fallo el driver");
		}
		
		/*	Cargar usuarios desde los valores de entrada (o web.xml)
		Enumeration<String> itr = sc.getInitParameterNames();
		while(itr.hasMoreElements()){
			usuario = itr.nextElement().toString();
			password = sc.getInitParameter(usuario);
			logins.put(usuario, password);
		}*/
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("<br>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		usuario = request.getParameter("usuario");
		password = request.getParameter("password");
		response.getWriter().append(usuario).append(" _ ").append(password);

		if(logins.containsKey(usuario)) {
			String pass = (String)logins.get(usuario);
			if(pass.equals(password)) {		
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("usuario", usuario);
				sesion.setAttribute("password", password);
				if(usuario.equals("Admin")){
					sesion.setAttribute("isAdmin", true);
				}else{
					sesion.setAttribute("isAdmin", false);
				}
				
				response.sendRedirect("../JRuteros/vistas/Actividades/index.jsp");
			}
		}else{
			response.sendRedirect("../JRuteros/vistas/login.html");
		}
	}
}
