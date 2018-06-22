package DroidEye.DAO;

import DroidEye.JavaBean.WorkerBean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DroidEye on 2017/6/29.
 */
public class WorkerDAO extends CommonDAO {

    private static WorkerDAO workerDAO = null;

    private WorkerDAO() throws ClassNotFoundException {
        Class.forName(DBDRIVER);
    }

    public static WorkerDAO getWorkerDAOInstance() {
        if (workerDAO == null) {
            try {
                workerDAO = new WorkerDAO();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return workerDAO;
    }

    public WorkerBean queryWorkerAccount(String workerID) {
        WorkerBean worker = null;
        if (prepareMySql("SELECT * FROM worker WHERE worker_id=\'" +
                Integer.parseInt(workerID) + "\'")) {
            try {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    worker = new WorkerBean();
                    worker.setWorkerID(Integer.toString(rs.getInt(1)));
                    worker.setWorkerName(rs.getString(2));
                    worker.setWorkerPassword(rs.getString(3));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }
        }
        return worker;
    }

    public List<WorkerBean> queryAllWorkers() {
        WorkerBean worker = null;
        List<WorkerBean> workers = new ArrayList<>();
        if (prepareMySql("SELECT * FROM worker")) {
            try {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    worker = new WorkerBean();
                    worker.setWorkerID(Integer.toString(rs.getInt(1)));
                    worker.setWorkerName(rs.getString(2));
                    worker.setWorkerPassword(rs.getString(3));
                    workers.add(worker);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }
        }
        return workers;
    }
    }


