import java.text.DecimalFormat;

public class GameObject {
    // Information about the object's center (X and Y)
    private float[] center;
    // The object's velocity
    private float velocity;
    // The object's state (dead or alive)
    private boolean isStateActive;
    // The object's rotation
    private float rotation;

    // Constructor for GameObject
    public GameObject(){
        center = new float[2];
    }
    // Constructor for GameObject with parameters
    public GameObject(float[] center, float velocity, boolean isStateActive, float rotation){
        this.center = center;
        this.velocity = velocity;
        this.isStateActive = isStateActive;
        this.rotation = rotation;
    }

    // Gets the value of center
    public float[] getCenter() {
        return center;
    }
    // Gets the value of velocity
    public float getVelocity() {
        return velocity;
    }
    // Gets the value of the object's state
    public boolean getIsStateActive() {
        return isStateActive;
    }
    // Gets the value of rotation
    public float getRotation() {
        return rotation;
    }

    // Returns the information about GameObject in a string
    public String getGameObject(){
        // Sets a clearer status on whether the game object is alive or not
        String status = (isStateActive) ? "Alive" : "Dead";
        // Setting a decimal limit to only 2
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        return "Game Object Information:\n  Center: X["
                + df.format(center[0]) + "] Y[" + df.format(center[1]) +
                "]\n  Velocity: " + df.format(velocity) +
                "\n  Active Status: " + status +
                "\n  Rotation: " + df.format(rotation) +"°";
    }

}
