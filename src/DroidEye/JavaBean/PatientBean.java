package DroidEye.JavaBean;

/**
 * Created by DroidEye on 2017/6/27.
 */
public class PatientBean {

    private String patientID;
    private String patientName;
    private String patientPassword;
    private String patientProperty;

    public PatientBean() {
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }

    public String getPatientProperty() {
        return patientProperty;
    }

    public void setPatientProperty(String patientProperty) {
        this.patientProperty = patientProperty;
    }
}
