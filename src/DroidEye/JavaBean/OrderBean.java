package DroidEye.JavaBean;

import java.util.Date;

/**
 * Created by DroidEye on 2017/6/27.
 */
public class OrderBean {

    private String orderID;
    private String patientID;
    private String medicineID;
    private String workerID;
    private String quantity;
    private String totalPrice;
    private String orderProcess;

    public OrderBean() {
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(String medicineID) {
        this.medicineID = medicineID;
    }

    public String getWorkerID() {
        return workerID;
    }

    public void setWorkerID(String workerID) {
        this.workerID = workerID;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderProcess() {
        return orderProcess;
    }

    public void setOrderProcess(String orderProcess) {
        this.orderProcess = orderProcess;
    }


}
