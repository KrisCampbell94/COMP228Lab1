import javax.swing.*;

public class PatientTest {
    public static void main(String[] args) {
        // An auto counter for the Patient Identification
        int idCounter = 0;
        // Create an instance of Patient
        Patient myPatient = new Patient();
        // Call method inputInfo with the idCounter and myPatient as parameters
        inputInfo(myPatient, idCounter);
        outputInfo(myPatient);

    }
    // Method that allows the user to input information via message dialog box
    public static void inputInfo(Patient aPatient, int counter){
        // A string array of messages
        String[] message = {"Enter your First Name",
        "Enter your Last Name",
        "Enter your Address", "Enter your City",
        "Enter your Province", "Enter your Postal Code"};
        // A for loop that continually prompts the user to enter their information
        for(int x = 0; x < message.length; x++){
            // Sets the value of a new string to the input of the dialog box
            String s = (String)JOptionPane.showInputDialog(message[x]);
            // If nothing is typed, x is minus by 1, thus continuing the for loop
            if(s.isEmpty()) x--;
            // If above is opposite, start a statement sequence that sets the Patient values to the present value
            else{
                if(x == 0) aPatient.setFirstName(s);
                else if (x == 1) aPatient.setLastName(s);
                else if (x == 2) aPatient.setAddress(s);
                else if (x == 3) aPatient.setCity(s);
                else if (x == 4) aPatient.setProvince(s);
                else if (x == 5) aPatient.setPostalCode(s);
            }
        }
        // Set the patient id to the idCounter, then add it by one for future uses
        aPatient.setPatientId(counter);
        counter++;

    }
    // Displays the output information of said Patient
    public static void outputInfo(Patient aPatient){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,aPatient.getPatientInfo());
    }

}
