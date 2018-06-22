package DroidEye.DAO;

import java.sql.*;

/**
 * Created by DroidEye on 2017/6/28.
 */
public class CommonDAO {

    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/outpatient";
    public static final String DBUSER = "root";
    public static final String DBPASS = "admin";

    protected Connection conn = null;
    protected PreparedStatement pstmt = null;
    protected ResultSet rs = null;

    protected CommonDAO() {
    }


    protected boolean prepareMySql(String sql) {
        try {
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            pstmt = conn.prepareStatement(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected boolean closePsAndConn() {
        if (conn != null) {
            try {
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    protected boolean closeResultSet() {
        if (rs != null) {
            try {
                rs.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    protected boolean closeMySql() {
        if (closeResultSet() && closePsAndConn()) {
            return true;
        }
        return false;
    }
}
