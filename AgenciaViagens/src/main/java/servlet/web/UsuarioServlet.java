package servlet.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usuario.DAO.UsuarioDAO;
import usuario.model.Usuario;


@WebServlet("/")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;

	
	public void init() throws ServletException {
		usuarioDAO = new UsuarioDAO();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUsuario(request, response);
				break;
			case "/delete":
				deleteUsuario(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUsuario(request, response);
				break;
			default:
				listUsuario(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario-form.jsp");
		dispatcher.forward(request, response);
	}

	// Inserir usuario
	private void insertUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");
		Usuario newUsuario = new Usuario(nome, email, cpf);
		usuarioDAO.insertUsuario(newUsuario);
		response.sendRedirect("list");
	}

	// Deletar usuario
	private void deleteUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		usuarioDAO.deleteUsuario(id);
		response.sendRedirect("list");

	}
	
	// Editar usuario
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Usuario existingUsuario = usuarioDAO.selectUsuario(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario-form.jsp");
		request.setAttribute("usuario", existingUsuario);
		dispatcher.forward(request, response);

	}
	
	// Update usuario
	private void updateUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");

		Usuario book = new Usuario(id, nome, email, cpf);
		usuarioDAO.updateUsuario(book);
		response.sendRedirect("list");
	}
	// Listar usuario
	private void listUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Usuario> listUsuario = usuarioDAO.selectAllUsuarios();
		request.setAttribute("listUsuario", listUsuario);
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario-list.jsp");
		dispatcher.forward(request, response);
	}
}
