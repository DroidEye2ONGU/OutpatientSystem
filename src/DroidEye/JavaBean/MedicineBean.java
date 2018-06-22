package DroidEye.JavaBean;

/**
 * Created by DroidEye on 2017/6/27.
 */
public class MedicineBean {

    private String medicineID;
    private String medicineName;
    private String medicinePrice;
    private String medicineFunction;

    public MedicineBean() {
    }

    public String getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(String medicineID) {
        this.medicineID = medicineID;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(String medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public String getMedicineFunction() {
        return medicineFunction;
    }

    public void setMedicineFunction(String medicineFunction) {
        this.medicineFunction = medicineFunction;
    }
}
