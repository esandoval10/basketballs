public class Basketball {

    private double radius;

    public Basketball(double r) { // Constructor
        radius = r;
    }

    public double getVolume() {
        return ((4 / 3) * Math.PI * Math.pow(radius, 3));
    }

    // Getters and setters//
    public void setRadius(double r) {
        radius = r;
    }

    public double getRadius() {
        return radius;
    }
}
