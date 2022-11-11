public class Bike {
    private String rider;
    private String color;
    private int direction; // steering angle in degrees: -45 to +45
    private double speed; // m/sec

    public Bike(){
        this("NaN", "NaN");
    }

    public Bike(String rider, String color) {
        this.rider = rider;
        this.color = color;
    }

    /**
     * the steer method sets the direction of the bike in an angle of 45 to -45 degrees
     * @param deltaR
     */
    public void steer(int deltaR){
        if(this.direction + deltaR > 45 || this.direction + deltaR < -45){
            throw new Error("Steering angle is to big! Steering is only possible between +45 and -45 Degree");
        }
        this.direction = this.direction + deltaR;
    }

    /**
     * calculates the speed v = v + a * t
     * @param a m/s^2
     * @param sec seconds
     */
    public void accelerate (double a, double sec){
        this.speed = this.speed + a * sec;
    }

    public String toString(){
        return  this.getClass().getSimpleName() + ":" + "Rider: " + this.rider + " | Color: " + this.color + " | Direction: " + this.direction + " | kmh: " + this.getKmh();
    }

    /**
     * calculates the km/h
     * @return km/h
     */
    public double getKmh() {
       return this.speed * 3.6;
    }

    public String getRider() {
        return rider;
    }

    public void setRider(String rider) {
        this.rider = rider;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
