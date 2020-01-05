package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConexion {
	
//	Constructor privado
	private MySQLConexion() {}
	
//	Método estático para obtener la conexión
	public static Connection getConexion() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/BD_LibrosElectronicos2019";
			conn = DriverManager.getConnection(url, "root", "PrOyEcToWaTsOn**");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Error >> Driver No Instalado!...");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error >> de conexión de la BD");
		}
		return conn;
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conexion = MySQLConexion.getConexion();
		if (conexion != null) {
			System.out.println("Conexión exitosa");
			System.out.println(conexion);
			Statement stmt = conexion.createStatement();
			String sql = "select * from usuarios";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println("Código: " + rs.getString(1) + " / " + "Clave: " + rs.getString(2) + " / " + "Nombre: " + rs.getString(3) + " / " + "Apellidos: " + rs.getString(4) + " " + rs.getString(5));
			}
		} else {
				System.out.println("Error de conexión");
		}
	}
}