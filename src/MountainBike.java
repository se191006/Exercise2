public class MountainBike extends Bike {
    private boolean damping;

    public MountainBike(String rider, String color, String damping) {
        super(rider, color);
        setDamping(damping);
    }

    public String isDamping() {
        String translation = "off";
        if (damping){
            translation = "on";
        }
        return translation;
    }

    public void setDamping(String damping) {
        this.damping = false;
        if(damping.equals("true") || damping.equals("on")){
            this.damping = true;
        }
    }

    @Override
    public String toString(){
        return super.toString() + " | Damping: " + isDamping();
    }
}
