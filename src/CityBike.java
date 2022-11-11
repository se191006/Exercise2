public class CityBike extends Bike {

    public boolean light;

    public CityBike(String rider, String color, String light) {
        super(rider,color);
        setLight(light);
    }

    public String isLight() {
        String translation = "off";
        if(light){
            translation = "on";
        }
        return translation;
    }

    public void setLight(String light) {
        this.light = false;
        if(light.equals("true") || light.equals("on")){
            this.light = true;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Lights: " + isLight();
    }
}
