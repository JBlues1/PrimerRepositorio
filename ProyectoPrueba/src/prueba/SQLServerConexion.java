package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerConexion {

// Constructor privado
	private SQLServerConexion() {}
	
//	Método estático para obtener la conexión
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:54086;databaseName=Negocios2018";
			con = DriverManager.getConnection(url, "sa", "sql");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return con;
	}

//	Método main para probar la conexión de la BD y la ejecución de la sentencia
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conexion = SQLServerConexion.getConnection();
		if (conexion != null) {
			System.out.println("Conexión exitosa");
			System.out.println(conexion);
			Statement stmt = conexion.createStatement();
			String sql = "select * from tb_categorias";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println("Código: " + rs.getInt(1) + " - " + "Nombre: " + rs.getString(2) + " - " + "Descripción: " + rs.getString(3));
			}
		} else {
			System.out.println("Error de conexión");
		}
	}

}
