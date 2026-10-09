package icai.dtc.isw.controler;

import icai.dtc.isw.dao.UsuarioDAO;

public class UsuarioControler {
	UsuarioDAO usuarioDAO=new UsuarioDAO();
	public boolean registrar(String nombre, String correo, String contrasena) {return usuarioDAO.registrar(nombre, correo, contrasena);}
	public String login(String correo, String contrasena) {return usuarioDAO.login(correo, contrasena);}
}
