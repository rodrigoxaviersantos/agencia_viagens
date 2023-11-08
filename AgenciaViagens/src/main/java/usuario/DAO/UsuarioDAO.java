package usuario.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import usuario.model.Usuario;

public class UsuarioDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/agencia?useSSL=false";

	private String jdbcUsuarioNAME = "root";

	private String jdbcPassword = "123456";

//	private String jdbcDRIVER = "com.mysql.jdbc.Driver";

	private static final String INSERT_USUARIOS_SQL = "INSERT INTO usuarios" + " (nome, email, cpf) VALUES"
			+ "(?, ?, ?)";

	private static final String SELECT_USUARIOS_BY_ID = "select id,nome,email,cpf from usuarios where id =?";
	private static final String SELECT_ALL_USUARIOS = "select * from usuarios";
	private static final String DELETE_USUARIOS_SQL = "delete from usuarios where id = ?;";
	private static final String UPDATE_USUARIOS_SQL = "update usuarios set nome = ? ,email= ?, cpf =? where id = ?;";

	public UsuarioDAO() {
	}

	protected Connection geConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsuarioNAME, jdbcPassword);
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}

	// Insert ususario
	public void insertUsuario(Usuario usuario) throws SQLException {
		System.out.println(INSERT_USUARIOS_SQL);
		try (Connection connection = geConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USUARIOS_SQL)) {
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getCpf());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Usuario selectUsuario(int id) {
		Usuario Usuario = null;

		try (Connection connection = geConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USUARIOS_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String cpf = rs.getString("cpf");
				Usuario = new Usuario(id, nome, email, cpf);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Usuario;
	}

	public List<Usuario> selectAllUsuarios() {

		List<Usuario> Usuarios = new ArrayList<>();

		try (Connection connection = geConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USUARIOS);) {
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String cpf = rs.getString("cpf");
				Usuarios.add(new Usuario(id, nome, email, cpf));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Usuarios;
	}

	public boolean updateUsuario(Usuario Usuario) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = geConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USUARIOS_SQL);) {
			System.out.println("updated Usuario:" + statement);
			statement.setString(1, Usuario.getNome());
			statement.setString(2, Usuario.getEmail());
			statement.setString(3, Usuario.getCpf());
			statement.setInt(4, Usuario.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public boolean deleteUsuario(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = geConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USUARIOS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			e.printStackTrace(System.err);
			System.err.println("SQLtate: " + ((SQLException) e).getSQLState());
			System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
			System.err.println("Message: " + e.getMessage());
			Throwable t = ex.getCause();
			while (t != null) {
				System.out.println("Cause: " + t);
				t = t.getCause();
			}

		}

	}

}
