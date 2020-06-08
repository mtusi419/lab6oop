package lab6;

import java.awt.geom.Rectangle2D;

/**
 * ��������� ����� ��� �������� Tricorn
 * **/

public class Tricorn extends FractalGenerator {
    public static final int MAX_ITERATIONS = 2000;
    public void getInitialRange(Rectangle2D.Double rect){
        rect.x = -2;
        rect.y = -2;
        rect.height = 2 - rect.x;
        rect.width = 2 - rect.y;
    }

    //���������� ���������� �������� ��� ����� (x, y), ��� ������� ��������, ��� ����� �� �����������
    // ������. ���������� -1, ���� ����� ��������� �� ��������� ������������
    public int numIterations(double x, double y){
        int iterations = 0;
        Complex c = new Complex(x, y);
        Complex z = new Complex(0, 0);
        while (iterations < MAX_ITERATIONS){
            iterations++;
            z = z.step2sopr().sum(c);
            if (z.isMoreThan(2)){
                return iterations;
            }
        }
        return -1;
    }

    @Override
    public String toString(){
        return "Tricorn";
    }
}
