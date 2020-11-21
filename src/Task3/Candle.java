package Task3;

public class Candle {
    private double[] arrPoints = new double[4];

    public Candle(double start, double end, double min, double max) {
        arrPoints[0] = start;
        arrPoints[3] = end;
        arrPoints[1] = max;
        arrPoints[2] = min;
    }

    public double[] getArrPoints() {
        return arrPoints;
    }

    public double getStart(){
        return arrPoints[0];
    }

    public double getEnd(){
        return arrPoints[3];
    }

    public double getMax(){
        return arrPoints[1];
    }

    public double getMin(){
        return arrPoints[2];
    }
}
