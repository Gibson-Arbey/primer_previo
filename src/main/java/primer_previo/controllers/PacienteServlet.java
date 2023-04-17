package primer_previo.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import primer_previo.dao.PacienteDao;
import primer_previo.entities.Paciente;


/**
 * Servlet implementation class PacienteServlet
 */
@WebServlet("/")
public class PacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PacienteDao pDao;
    private DateTimeFormatter format; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PacienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
    	this.format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.pDao = new PacienteDao(); 	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
			switch(action) {
			case"/Nuevo_Paciente": showPage(request, response, "nuevoPaciente.jsp");
				break;
			case"/delete": eliminarPaciente(request, response);
				break;
			case"/edit": showEditForm(request, response);
				break;
			case"/insert": insertarPaciente(request, response);
				break;
			case"/update": actualizarPaciente(request, response);
				break;
			default:	listPacientes(request, response);
				break;
			}
		}catch(SQLException e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

	private void showPage(HttpServletRequest request, HttpServletResponse response, String pag) 
			throws ServletException, IOException {
		request.getRequestDispatcher(pag).forward(request, response);
	}
	
	private void  showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Paciente p = pDao.find(id);
		request.setAttribute("pac", p);
		request.getRequestDispatcher("nuevoPaciente.jsp").forward(request, response);
	}
	
	private void insertarPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		String fechanacimiento = request.getParameter("fechanacimiento");
		LocalDate fecha = LocalDate.parse(fechanacimiento, format);
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		float peso = Float.parseFloat(request.getParameter("peso"));
		float estatura = Float.parseFloat(request.getParameter("estatura"));
		pDao.insert(new Paciente(documento, nombre, apellido, email, genero, fecha, telefono, direccion, peso, estatura));
		response.sendRedirect("PacienteList");
	}
	
	private void actualizarPaciente(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, SQLException, IOException {
		Paciente p = new Paciente();
		int id = Integer.parseInt(request.getParameter("id"));
		p = pDao.find(id);
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		String fechanacimiento = request.getParameter("fechanacimiento");
		LocalDate fecha = LocalDate.parse(fechanacimiento, format);
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		float peso = Float.parseFloat(request.getParameter("peso"));
		float estatura = Float.parseFloat(request.getParameter("estatura"));
		
		p.setDocumento(documento);
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setEmail(email);
		p.setGenero(genero);
		p.setFechanacimiento(fecha);
		p.setTelefono(telefono);
		p.setDireccion(direccion);
		p.setPeso(peso);
		p.setEstatura(estatura);
		pDao.update(p);
		response.sendRedirect("PacienteList");
	}
	
	private void  eliminarPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Paciente p = pDao.find(id);
		pDao.delete(p);
		response.sendRedirect("PacienteList");
	}
	
	private void listPacientes(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, SQLException, IOException {
			List<Paciente> listPac = new ArrayList<>();
			listPac = pDao.list(); 
			for(Paciente p: listPac) {
				p.calcularImc();
				p.setEstado();
			}
			request.setAttribute("listPacientes", listPac);
			showPage(request, response,"index.jsp");
	}
	
}
