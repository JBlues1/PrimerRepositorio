package prueba;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "system", "agile2020");
				System.out.println("Conexión exitosa: " + conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Conexión no exitosa: " + e.getMessage());
		}
	}

}
