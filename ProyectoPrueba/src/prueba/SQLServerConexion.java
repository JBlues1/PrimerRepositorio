package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerConexion {

// Constructor privado
	private SQLServerConexion() {}
	
//	M�todo est�tico para obtener la conexi�n
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

//	M�todo main para probar la conexi�n de la BD y la ejecuci�n de la sentencia
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conexion = SQLServerConexion.getConnection();
		if (conexion != null) {
			System.out.println("Conexi�n exitosa");
			System.out.println(conexion);
			Statement stmt = conexion.createStatement();
			String sql = "select * from tb_categorias";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println("C�digo: " + rs.getInt(1) + " - " + "Nombre: " + rs.getString(2) + " - " + "Descripci�n: " + rs.getString(3));
			}
		} else {
			System.out.println("Error de conexi�n");
		}
	}

}
