package control;


import model.User;
import DAO.UserDao;
import javax.swing.JFileChooser;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class AddUserController {
    
    public boolean addUser(User usuario, int id){
        UserDao dao = new UserDao();        
        try {
            if (id == 0) {
                dao.save(usuario);
            } else {
                dao.edit(usuario);
            }
            return true;
        }catch(Exception ex){
            return false;
        } 
    }
}
