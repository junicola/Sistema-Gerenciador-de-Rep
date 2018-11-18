package control;

import DAO.BillDao;
import DAO.PayBillDao;
import DAO.UserDao;
import java.util.List;
import model.Bill;
import model.PayBill;
import model.User;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class AddBillController {

    public boolean addBill(Bill b, String name, PayBill pb) {
        BillDao dao = new BillDao();
        PayBillDao daoP = new PayBillDao();
        UserDao daoU = new UserDao();
        List<User> user = daoU.searchAll();
        try {
            if (b.getId() == 0) {
                dao.save(b);    
                //voltar o id da conta
                int id = dao.searchById();
                for(User u : user)
                    if(pb.getNameUser().equals(u.getName())){
                        pb.setIdUser(u.getId());
                        pb.setIdBill(id);
                        pb.setStatus(1);
                        daoP.save(pb);
                    }
            } else {

                daoP.edit(pb);
                dao.edit(b);
            }
            return true;
        }catch(Exception ex){
            System.out.println(" " +ex);
            return false;
        } 
    }

}

