package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;

public class main {

    public static void main(String[] args){
        Usuario usuario = new Usuario();
        usuario.setNombre("juan");
        usuario.setPassword("1234");
        UsuarioDAO dao = new UsuarioDAO();
        dao.crear(usuario);
     }
    
}
