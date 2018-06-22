package DroidEye.DAO;

import DroidEye.JavaBean.OrderBean;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DroidEye on 2017/6/29.
 */
public class OrderDAO extends CommonDAO {

    private static OrderDAO orderDAO = null;

    private OrderDAO() throws ClassNotFoundException {
        Class.forName(DBDRIVER);
    }

    public static OrderDAO getOrderDAOInstance() {
        if (orderDAO == null) {
            try {
                orderDAO = new OrderDAO();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return orderDAO;
    }

    public boolean addNewOrder(OrderBean order) {
        String patientID = order.getPatientID();
        String medicentID = order.getMedicineID();
        String quantity = order.getQuantity();


        String totalPrice = Integer.toString((Integer.parseInt(MedicineDAO.getMedicineDAOInstance()
                                        .querySingleMedicine(medicentID).getMedicinePrice())) * Integer.parseInt(quantity));
        if (prepareMySql("INSERT INTO patient_order(patient_id," +
                "medicine_id,quantity,total_price) VALUES(?,?,?,?)")) {
            try {
                pstmt.setInt(1,Integer.parseInt(patientID));
                pstmt.setInt(2, Integer.parseInt(medicentID));
                pstmt.setString(3, quantity);
                pstmt.setString(4, totalPrice);
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

    public List<OrderBean> queryOrdersGroupByWorker(String workerID) {
        int workerID2 = Integer.parseInt(workerID);
        List<OrderBean> workerOrders = new ArrayList<>();
        OrderBean order;
        if (prepareMySql("SELECT * FROM patient_order WHERE worker_id=" + workerID2)) {
            try {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    order = new OrderBean();
                    order.setOrderID(Integer.toString(rs.getInt(1)));
                    order.setPatientID(Integer.toString(rs.getInt(2)));
                    order.setMedicineID(Integer.toString(rs.getInt(3)));
                    order.setWorkerID(Integer.toString(rs.getInt(4)));
                    order.setQuantity(rs.getString(5));
                    order.setTotalPrice(rs.getString(6));
                    order.setOrderProcess(rs.getString(7));
                    workerOrders.add(order);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }

        }
        return workerOrders;
    }

    public List<OrderBean> queryOrdersGroupByPatient(String patientID) {
        int patientID2 = Integer.parseInt(patientID);
        List<OrderBean> workerOrders = new ArrayList<>();
        OrderBean order;
        if (prepareMySql("SELECT * FROM patient_order WHERE worker_id=" + patientID2)) {
            try {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    order = new OrderBean();
                    order.setOrderID(Integer.toString(rs.getInt(1)));
                    order.setPatientID(Integer.toString(rs.getInt(2)));
                    order.setMedicineID(Integer.toString(rs.getInt(3)));
                    order.setWorkerID(Integer.toString(rs.getInt(4)));
                    order.setQuantity(rs.getString(5));
                    order.setTotalPrice(rs.getString(6));
                    order.setOrderProcess(rs.getString(7));
                    workerOrders.add(order);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }

        }
        return workerOrders;
    }

    public List<OrderBean> queryAllOrders() {
        List<OrderBean> orders = new ArrayList<>();
        OrderBean order;
        if (prepareMySql("SELECT * FROM patient_order")) {
            try {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    order = new OrderBean();
                    order.setOrderID(Integer.toString(rs.getInt(1)));
                    order.setPatientID(Integer.toString(rs.getInt(2)));
                    order.setMedicineID(Integer.toString(rs.getInt(3)));
                    order.setWorkerID(Integer.toString(rs.getInt(4)));
                    order.setQuantity(rs.getString(5));
                    order.setTotalPrice(rs.getString(6));
                    order.setOrderProcess(rs.getString(7));
                    orders.add(order);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }
        }
        return orders;
    }

    public boolean modifyOrderProcess(String orderID, String process) {
        if (prepareMySql("UPDATE patient_order SET order_process=\'" +
                process + "\' WHERE order_id=" + Integer.parseInt(orderID))) {
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

    public boolean setOrderWorker(String workerID, String orderID) {
        if (prepareMySql("UPDATE patient_order SET worker_id=" + Integer.parseInt(workerID) + " WHERE order_id=" + Integer.parseInt(orderID))) {
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
