package Task3;

import java.awt.*;

public class DrawCandle {

    public static void draw(LineDrawer ld, ScreenConverter sc, int x, int dX, double[] arrPoints){
        if (arrPoints[0] < arrPoints[3]){
            ld.setColor(Color.blue);
        } else{
            ld.setColor(Color.red);
        }
        ScreenPoint p1 = new ScreenPoint(x+dX/2, sc.r2s(new RealPoint(x, arrPoints[1])).getY());
        ScreenPoint p2 = new ScreenPoint(x+dX/2, sc.r2s( new RealPoint(x, arrPoints[2])).getY());

        // min-max
        ld.drawLine(p1, p2);
        for (int i = 0; i < dX; i++) {
            ScreenPoint p5 = new ScreenPoint( x+i,  sc.r2s(new RealPoint(x, arrPoints[0])).getY());
            ScreenPoint p6 = new ScreenPoint( x+i,  sc.r2s(new RealPoint(x, arrPoints[3])).getY());

            //candle
            ld.drawLine(p5, p6);
        }
    }
}
