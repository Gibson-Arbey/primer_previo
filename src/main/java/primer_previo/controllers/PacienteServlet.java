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
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PacienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
    
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
			case"/Nuevo_paciente": showPage(request, response, "nuevoPaciente.jsp");
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
		
	}
	
	private void insertarPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		
	}
	
	private void actualizarPaciente(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, SQLException, IOException {
	}
	
	private void  eliminarPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
	}
	
	private void listPacientes(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, SQLException, IOException {
			List<Paciente> listPac = new ArrayList<>();
			listPac = pDao.list(); 
			
			request.setAttribute("listPacientes", listPac);
			showPage(request, response,"index.jsp");
	}
	
}
