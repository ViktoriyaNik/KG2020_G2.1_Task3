package Task3;

import java.util.ArrayList;
import java.util.List;

public class Diagram {
    private List<Candle> candles = new ArrayList<>();

    public Diagram() {

    }

    public void group(List<Candle> candle, int n){
        for (int i = 0; i < candle.size() - 1; i += n) {
            double min = candle.get(i).getMin();
            double max = candle.get(i).getMax();
            for (int j = 0; j < n && i + j < candle.size(); j++) {
                if(candle.get(i+j).getMin()<min){
                    min = candle.get(i+j).getMin();
                }
                if(candle.get(i+j).getMax()>max){
                    max = candle.get(i+j).getMax();
                }
            }
            if(i+n<candle.size()) {
                candles.add(new Candle(candle.get(i).getStart(), candle.get(i + n - 1).getEnd(), max, min));
            } else{
                candles.add(new Candle(candle.get(i).getStart(), candle.get(candle.size() - 1).getEnd(), max, min));
            }
        }
    }

    public void createDiagram(List<Candle> candle) {
        for (int i = 0; i < candle.size() - 1; i += 2) {
            Candle c1 = candle.get(i);
            Candle c2 = candle.get(i + 1);
            candles.add(new Candle(c1.getStart(), c2.getEnd(), Math.max(c1.getMax(), c2.getMax()), Math.min(c1.getMin(), c2.getMin())));
        }
    }

    public void createStartDiagram() {

        candles.add(new Candle(10, 50, 10, 50));
        candles.add(new Candle(50, 30, 10, 60));
        candles.add(new Candle(30, 35, 20, 40));
        candles.add(new Candle(35, 60, 30, 80));
        candles.add(new Candle(60, 40, 10, 60));
        candles.add(new Candle(40, 10, 10, 50));
        candles.add(new Candle(10, -20, -30, 40));
        candles.add(new Candle(-20, 50, -10, 50));
        candles.add(new Candle(50, 70, 10, 80));
        candles.add(new Candle(70, 10, -15, 75));

        candles.add(new Candle(10, 15, 0, 40));
        candles.add(new Candle(15, 40, -10, 50));
        candles.add(new Candle(40, 80, 30, 80));
        candles.add(new Candle(80, 50, 20, 90));
        candles.add(new Candle(50, -30, -30, 60));
        candles.add(new Candle(-30, 10, -40, 50));
        candles.add(new Candle(10, 20, 0, 40));
        candles.add(new Candle(20, -30, -40, 50));
        candles.add(new Candle(-30, 10, -30, 20));
        candles.add(new Candle(10, 50, 10, 50));

        //candles.add(new Candle(10, 50, 10, 50));
    }

    public void printCandles() {
        int i = 1;
        for (Candle candle : candles) {
            System.out.println(i + ") open = " + candle.getArrPoints()[0] + ";  high =" + candle.getArrPoints()[1] +
                    ";  low = " + candle.getArrPoints()[2] + ";  close = " + candle.getArrPoints()[3]);
            i++;
        }
    }

    public void draw(LineDrawer ld, ScreenConverter sc, int x, int deltaX) {
        int screenX = sc.r2s(new RealPoint(x, 0)).getX();
        for (Candle candle : candles) {
            DrawCandle.draw(ld, sc, screenX, deltaX, candle.getArrPoints());
//            candle.draw(ld, sc, screenX, deltaX);
            screenX += 2 * deltaX;
        }
    }

    public List<Candle> getCandles() {
        return candles;
    }

    public double getMinCandle() {
        return Logic.getMinCandle(candles);
    }

    public double getMaxCandle() {
        return Logic.getMaxCandle(candles);
    }

}

