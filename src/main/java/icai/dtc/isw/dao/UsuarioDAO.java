package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

	// Devuelve false si no se pudo guardar (por ejemplo, el correo ya existe: es UNIQUE en la tabla)
	public boolean registrar(String nombre, String correo, String contrasenaCifrada) {
		Connection con = ConnectionDAO.getInstance().getConnection();
		String consulta = "INSERT INTO usuarios (nombre, correo, contrasena) VALUES (?, ?, ?)";
		try (PreparedStatement pst = con.prepareStatement(consulta)) {
			pst.setString(1, nombre);
			pst.setString(2, correo);
			pst.setString(3, contrasenaCifrada);
			pst.executeUpdate();
			return true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	// Devuelve el nombre del usuario si correo y contraseña coinciden, o null si no
	public String login(String correo, String contrasenaCifrada) {
		Connection con = ConnectionDAO.getInstance().getConnection();
		String consulta = "SELECT nombre FROM usuarios WHERE correo = ? AND contrasena = ?";
		String nombre = null;
		try (PreparedStatement pst = con.prepareStatement(consulta)) {
			pst.setString(1, correo);
			pst.setString(2, contrasenaCifrada);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					nombre = rs.getString(1);
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return nombre;
	}
}
