package DroidEye.DAO;

import DroidEye.JavaBean.MedicineBean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DroidEye on 2017/6/29.
 */
public class MedicineDAO extends CommonDAO {

    private static MedicineDAO medicineDAO = null;

    private MedicineDAO() throws ClassNotFoundException {
        Class.forName(DBDRIVER);
    }

    public static MedicineDAO getMedicineDAOInstance() {
        if (medicineDAO == null) {
            try {
                medicineDAO = new MedicineDAO();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return medicineDAO;
    }

    public List<MedicineBean> queryAllMedicines() {
        List<MedicineBean> allMedicine = new ArrayList<>();
        MedicineBean medicine;
        if (prepareMySql("SELECT * FROM medicine")) {
            try {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    medicine = new MedicineBean();
                    medicine.setMedicineID(Integer.toString(rs.getInt(1)));
                    medicine.setMedicineName(rs.getString(2));
                    medicine.setMedicinePrice(rs.getString(3));
                    medicine.setMedicineFunction(rs.getString(4));
                    allMedicine.add(medicine);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }
        }
        return allMedicine;
    }

    public MedicineBean querySingleMedicine(String medicineID) {
        MedicineBean medicine = null;
        if (prepareMySql("SELECT * FROM medicine WHERE medicine_id=" + Integer.parseInt(medicineID))) {
            try {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    medicine = new MedicineBean();
                    medicine.setMedicineID(Integer.toString(rs.getInt(1)));
                    medicine.setMedicineName(rs.getString(2));
                    medicine.setMedicinePrice(rs.getString(3));
                    medicine.setMedicineFunction(rs.getString(4));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }
        }
        return medicine;
    }

    public int getMedicineNumber() {
        int sum = 0;
        if (prepareMySql("SELECT COUNT(*) AS medicine_number FROM medicine")) {
            try {
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    sum = rs.getInt("medicine_number");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }
        }
        return sum;
    }



}
