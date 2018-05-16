// The information class of the Patient
public class Patient {
    // The patient's identification
    private int patientId;
    // The patient's first name
    private String firstName;
    // The patient's last name
    private String lastName;
    // The patient's address location
    private String address;
    // The patient's city location
    private String city;
    // The patient's province location
    private String province;
    // The patient's postal code
    private String postalCode;

    // Gets the patient's id
    public int getPatientId() {
        return patientId;
    }
    // Sets a new value to the patient's id
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    // Gets the patient's first name
    public String getFirstName() {
        return firstName;
    }
    // Sets a new value to the patient's first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    // Gets the patient's last name
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // Gets the patient's address
    public String getAddress() {
        return address;
    }
    // Sets a new value to the patient's address
    public void setAddress(String address) {
        this.address = address;
    }
    // Gets the patient's city
    public String getCity() {
        return city;
    }
    // Sets a new value to the patient's city
    public void setCity(String city) {
        this.city = city;
    }
    // Gets the patient's province
    public String getProvince() {
        return province;
    }
    // Sets a new value to the patient's province
    public void setProvince(String province) {
        this.province = province;
    }
    // Gets the patient's postal code
    public String getPostalCode() {
        return postalCode;
    }
    // Sets a new value to the patient's postal code
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    // Default constructor class
    public Patient(){
    }

    public String getPatientInfo(){
        return "Patient ID : " + patientId
                + "\nFull Name : " + firstName + " " + lastName
                + "\nAddress : " + address + ", "
                + city + ", " + province + ", "
                + postalCode;
    }
}
