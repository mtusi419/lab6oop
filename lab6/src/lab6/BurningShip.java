package lab6;

import java.awt.geom.Rectangle2D;

/**
 * ��������� ����� ��� �������� BurningShip
 * **/

public class BurningShip extends FractalGenerator {
    public static final int MAX_ITERATIONS = 2000;
    public void getInitialRange(Rectangle2D.Double rect){
        rect.x = -2;
        rect.y = -2.5;
        rect.height = 2 - rect.x;
        rect.width = 1.5 - rect.y;
    }

    //���������� ���������� �������� ��� ����� (x, y), ��� ������� ��������, ��� ����� �� �����������
    // ������. ���������� -1, ���� ����� ��������� �� ��������� ������������
    public int numIterations(double x, double y){
        int iterations = 0;
        Complex c = new Complex(x, y);
        Complex z = new Complex(0, 0);
        while (iterations < MAX_ITERATIONS){
            iterations++;
            z = z.AbsImAndReParts().step2().sum(c);
            if (z.isMoreThan(2)){
                return iterations;
            }
        }
        return -1;
    }

    @Override
    public String toString(){
        return "Burning Ship";
    }
}
