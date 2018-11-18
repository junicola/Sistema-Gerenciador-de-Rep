package control;

import DAO.BillDao;
import DAO.PayBillDao;
import model.User;
import view.AddBill;
import view.AddUser;
import view.Main;
import DAO.UserDao;
import java.util.List;
import model.Bill;
import model.PayBill;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class MainController {
    //DAO users


    public List<User> getDataUsers() {
        UserDao userDao = new UserDao();
        return userDao.searchAll();
    }

    public void removeUser(String email) {
        UserDao userDao = new UserDao();
        userDao.remove(email);
    }

    public void editUser(String email, Main main) {
        UserDao userDao = new UserDao();
        User usuario = userDao.searchByEmail(email);
        AddUser add = new AddUser(usuario.getEmail(), usuario.getName(), usuario.getPassword(), usuario.getRg(), usuario.getPhone(), usuario.getId(), main);              
        add.setVisible(true);
    }
    
    public List<PayBill> getDataPayBill(){
        PayBillDao pbDao = new PayBillDao();
        return pbDao.search();
    }

    public List<Bill> getDataBills() {
        BillDao billDao = new BillDao();
        return billDao.searchAll();
    };

    public void removeBill(String name) {
        PayBillDao pb = new PayBillDao();
        BillDao billDao = new BillDao();        
        pb.remove((billDao.searchByName(name)).getId()); 
        billDao.remove(name);        
    }

    public void editBill(String name, Main main) {
        BillDao billDao = new BillDao();
        Bill bill = billDao.searchByName(name);
        AddBill add = new AddBill(bill.getName(), (bill.getValue()).toString(), bill.getExpDate(), bill.getStatus(), bill.getId(), main);
        add.setVisible(true);
    }

}
