package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLConexion {
	
//	Constructor privado
	private PostgreSQLConexion() {}
	
//	M�todo de tipo est�tico para obtener la conexi�n a la base de datos
	public static Connection getConexion() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String usr = "postgres";
			String pwd = "agile2020";
			conn = DriverManager.getConnection(url, usr, pwd);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Error >> Driver no instalado!...");
		} catch (SQLException e) {
			System.out.println("Error >> No hay conexi�n con la BD");
		}
		return conn;
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conexion = PostgreSQLConexion.getConexion();
		if (conexion != null) {
			System.out.println("Conexi�n exitosa: " + conexion);
			Statement stmt = conexion.createStatement();
			String sql = "select * from tb_distrito";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println("C�digo de Distrito: " + rs.getInt(1) + " / " + "Nombre de Distrito: " + rs.getString(2));
			} 
		} else {
			System.out.println("Error de conexi�n");
		}
	}

}
