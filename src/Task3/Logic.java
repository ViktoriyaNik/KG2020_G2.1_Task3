package Task3;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    public static List<Candle> group(List<Candle> candles, int n) {
        List<Candle> groupCandles = new ArrayList<>();
        for (int i = 0; i < candles.size() - 1; i += n) {
            double min = candles.get(i).getMin();
            double max = candles.get(i).getMax();
            for (int j = 0; j < n && i + j < candles.size(); j++) {
                if (candles.get(i + j).getMin() < min) {
                    min = candles.get(i + j).getMin();
                }
                if (candles.get(i + j).getMax() > max) {
                    max = candles.get(i + j).getMax();
                }
            }
            groupCandles.add(new Candle(candles.get(i).getStart(), candles.get(i + n - 1).getEnd(), max, min));
        }
        return groupCandles;
    }

    public static double getMinCandle(List<Candle> candles) {
        double min = candles.get(0).getArrPoints()[2];
        for (Candle candle : candles) {
            double curr = candle.getArrPoints()[2];
            if (curr < min) {
                min = curr;
            }
        }
        return min;
    }

    public static double getMaxCandle(List<Candle> candles) {
        double max = candles.get(0).getArrPoints()[1];
        for (Candle candle : candles) {
            double curr = candle.getArrPoints()[1];
            if (curr > max) {
                max = curr;
            }
        }
        return max;
    }
}
