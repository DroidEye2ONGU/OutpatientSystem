package DroidEye.JavaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by DroidEye on 2017/6/27.
 */
public class AdminBean {

    private String adminID;
    private String adminName;
    private String adminPassword;

    public AdminBean() {
    }

    public AdminBean(String adminID, String adminName, String adminPassword) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
