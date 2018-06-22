package DroidEye.DAO;

import DroidEye.JavaBean.PatientBean;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by DroidEye on 2017/6/29.
 */
public class PatientDAO extends CommonDAO {

    private static PatientDAO patientDAO = null;

    private PatientDAO() throws ClassNotFoundException {
        Class.forName(DBDRIVER);
    }

    public static PatientDAO getPatientDAOInstance() {
        if (patientDAO == null) {
            try {
                patientDAO = new PatientDAO();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return patientDAO;
    }

    public String addNewPatient(String patientName, String patientPassword) {
        String patientID = null;
        if (prepareMySql("INSERT INTO patient(patient_name,patient_password) VALUES(?,?)")) {
            try {
                pstmt.setString(1, patientName);
                pstmt.setString(2, patientPassword);
                pstmt.executeUpdate();
                closeMySql();
                if (prepareMySql("SELECT patient_id FROM patient WHERE patient_name=\'" + patientName + "\' and patient_password=\'" + patientPassword + "\'")) {
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                        patientID = Integer.toString(rs.getInt(1));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }
        }
        return patientID;
    }


    public PatientBean queryPatient(String patientID) {
        PatientBean patient = null;
        if (prepareMySql("SELECT * FROM patient WHERE patient_id=" + Integer.parseInt(patientID))) {
            try {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    patient = new PatientBean();
                    patient.setPatientID(Integer.toString(rs.getInt(1)));
                    patient.setPatientName(rs.getString(2));
                    patient.setPatientPassword(rs.getString(3));
                    patient.setPatientProperty(rs.getString(4));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }
        }
        return patient;
    }

    public boolean updatePatientProperty(boolean isAdd, String property, String patientID) {
        if (prepareMySql("UPDATE patient SET patient_property=patient_property+" + Integer.parseInt(property) +
                " WHERE patient_id=" + Integer.parseInt(patientID))) {
            try {
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
