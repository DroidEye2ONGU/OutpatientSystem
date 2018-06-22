package DroidEye.DAO;


import DroidEye.JavaBean.AdminBean;
import DroidEye.JavaBean.MedicineBean;
import DroidEye.JavaBean.OrderBean;
import DroidEye.JavaBean.WorkerBean;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DroidEye on 2017/6/28.
 */
public class AdminDAO extends CommonDAO {

    private static AdminDAO adminDAO = null;

    private AdminDAO() throws ClassNotFoundException {
        Class.forName(DBDRIVER);
    }

    public static AdminDAO getAdminDAOInstance() {
        if (adminDAO == null) {
            try {
                adminDAO = new AdminDAO();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return adminDAO;
    }

    public boolean createAdminAccount(AdminBean adminBean) {
        if (prepareMySql("INSERT INTO admin VALUES(?,?,?)")) {
            try {
                pstmt.setString(1, adminBean.getAdminID());
                pstmt.setString(2, adminBean.getAdminPassword());
                pstmt.setString(3, adminBean.getAdminName());
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }
        }
        return false;
    }

    public AdminBean queryAdminAccount(String adminID) {
        AdminBean admin = null;
        if (prepareMySql("SELECT * FROM admin WHERE admin_id=\'" + adminID + "\'")) {
            try {
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    admin = new AdminBean();
                    admin.setAdminID(rs.getString("admin_id"));
                    admin.setAdminPassword(rs.getString("admin_password"));
                    admin.setAdminName(rs.getString("admin_name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }
        }

        return admin;
    }

    public boolean addNewMedicine(MedicineBean medicine) {
        String medicineName = medicine.getMedicineName();
        String medicinePrice = medicine.getMedicinePrice();
        String medicineFunction = medicine.getMedicineFunction();

        if (prepareMySql("INSERT INTO medicine(medicine_name,medicine_price," +
                "medicine_function) VALUES(?,?,?)")) {
            try {
                pstmt.setString(1, medicineName);
                pstmt.setString(2, medicinePrice);
                pstmt.setString(3, medicineFunction);
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }

        }
        return false;
    }

    public boolean addNewWorker(WorkerBean worker) {
        int workerID = Integer.parseInt(worker.getWorkerID());
        String workerName = worker.getWorkerName();
        if (prepareMySql("INSERT INTO worker(worker_id,worker_name) VALUES(?,?)")) {
            try {
                pstmt.setInt(1, workerID);
                pstmt.setString(2, workerName);
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }
        }
        return false;
    }


}
