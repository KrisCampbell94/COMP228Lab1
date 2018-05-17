import javax.swing.*;
import java.text.DecimalFormat;

public class GameObjectTest {
    public static void main(String[] args) {
        // GameObject Menu Creation Options
        Object[] menuOptions =
                { "Initialize","Update","Exit App" };
        // Setting up the message box frame
        JFrame frame = new JFrame();
        // Setting up GameObject initializer
        GameObject myGameObject = new GameObject();
        // The option integer
        int o;
        // Keep looping until the user presses the 3rd option
        do{
            // Sets the value of o from the user's input
            o = JOptionPane.showOptionDialog(frame,
                    "Select your Option",
                    "Game Object Main Menu",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, menuOptions, menuOptions[2]);
            // If user selects Initialized
            if(o == 0){
                myGameObject = initializing(frame);
                // Display the game object and its information
                JOptionPane.showMessageDialog(frame,myGameObject.getGameObject());
            }
            // If user selects Update
            else if (o == 1){
                myGameObject = updating(frame,myGameObject);
                JOptionPane.showMessageDialog(frame,myGameObject.getGameObject());
            }
        }while(o != 2);
    }// End of Main

    // Initializing the GameObject
    public static GameObject initializing(JFrame aFrame){
        // The setup variables for the GameObject
        float[] center = {0f,0f};
        float velocity = 0f, rotation = 0f;
        boolean isStateActive = false;
        // A string array of messages
        String[] messages = {"Enter the value of Center[X]",
        "Enter the value of Center[Y]","Enter the value of Velocity",
        "Enter the value of Rotation", "State the status of GameObject"};

        Object[] status = {"Alive","Dead"};
        int o = 0;

        // Prompts the user to enter all information
        for(int x = 0; x < messages.length; x++){
            // Sets the value of s to the user input
            String s="";
            if(x < 4)
                 s = JOptionPane.showInputDialog(messages[x]);
            // Asks a new question for the boolean isStatusActive
            else
                o = JOptionPane.showOptionDialog(
                        aFrame,messages[x],null,
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,status,status[1]);
            if(s.isEmpty() && x != 4) x--;
            else if (!s.isEmpty() && x != 4){
                // Center X Axis
                if(x == 0){
                    try{
                        center[0] = Float.parseFloat(s);
                    }
                    catch (NumberFormatException nfe){
                        x--;
                    }
                } // End if x == 0
                // Center Y Axis
                else if (x == 1){
                    try{
                        center[1] = Float.parseFloat(s);
                    }
                    catch (NumberFormatException nfe){
                        x--;
                    }
                } // End else if x == 1
                // Center Velocity
                else if (x == 2){
                    try{
                        velocity = Float.parseFloat(s);
                    }
                    catch (NumberFormatException nfe){
                        x--;
                    }
                } // End else if x == 2
                // Center Rotation
                else if (x == 3){
                    try{
                        rotation = Float.parseFloat(s);
                    }
                    catch (NumberFormatException nfe){
                        x--;
                    }
                } // End else if x == 3
            } // End else if
            else if (x == 4){
                isStateActive = (o==0);
            }
        }// End For Loop
        // Returns with new information
        return new GameObject(center,velocity,isStateActive,rotation);
    }// End of initializing

    // Updating the GameObject
    public static GameObject updating(JFrame aFrame, GameObject aGameObject){
        // Get the values of the original GameObject
        float[] center = aGameObject.getCenter();
        float velocity = aGameObject.getVelocity();
        float rotation = aGameObject.getRotation();
        boolean isStateActive = aGameObject.getIsStateActive();
        String status = (isStateActive) ? "Alive" : "Dead";
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        String[] updateMenu = {
                "Center [X] : \n" + df.format(center[0]),
                "Center [Y] : \n" + df.format(center[1]),
                "Velocity : \n" + df.format(velocity),
                "Rotation : \n" + df.format(rotation),
                "Active Status : \n" + status};
        int o = JOptionPane.showOptionDialog(aFrame,"Which would you like to update?",
                    "Game Object Update Menu",
                    JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,
                    null,updateMenu,updateMenu[4]);
        // Center X Axis
        if(o == 0)
            center[0] = floatModifier(updateMenu[0]);
        else if(o == 1)
            center[1] = floatModifier(updateMenu[1]);
        else if (o == 2)
            velocity = floatModifier(updateMenu[2]);
        else if (o == 3)
            rotation = floatModifier(updateMenu[3]);
        else if (o == 4)
            isStateActive = booleanModifier(updateMenu[4],aFrame);
        return new GameObject(center,velocity,isStateActive,rotation);

    }// End of updating
    // Modifies any float values
    public static float floatModifier(String name){
        float result = 0f;
        String s;
        for (int x = 0; x < 1; x++){
            s = JOptionPane.showInputDialog("Enter in new value of "+ name);
            if(s.isEmpty()) x--;
            else{
                try{
                    result = Float.parseFloat(s);
                }catch(NumberFormatException nfe){
                    x--;
                }
            }
        }// End of for loop
        // Return new value
        return result;
    }// End of modifier
    // Modifies any boolean values
    public static boolean booleanModifier(String name, JFrame aFrame){
        boolean result;
        Object[] status = {"Alive","Dead"};
        int o = JOptionPane.showOptionDialog(
                aFrame,"Select new value of" + name,
                null,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,status,status[1]);
        result = (o == 0);
        return result;
    }
}// End of Class
