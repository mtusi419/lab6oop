package lab6;

import java.awt.geom.Rectangle2D;

/**
 * ���� ����� ������������� ����� ��������� � �������� ��� ����������� ���������, 
 * ������� ����� ������������� � Fractal Explorer.
 */
public abstract class FractalGenerator {

    /**
     * ��� ����������� ��������������� ������� ��������� ������������� ���������� 
	 * � ����������� �� � �������� ������� ��������, ��������������� ������������� ���������. 
	 * �� ������������ ��� �������������� ��������� �������� � �������� 
	 * ������� �������� ��� ���������� ��������� � �. �.
     *
     * @param rangeMin ����������� �������� ��������� � ��������� �������
     * @param rangeMax ������������ �������� ��������� � ��������� �������
     *
     * @param size ������ ���������, �� �������� ������� ���������� ����������.
     *        ��������, ��� ����� ���� ������ ����������� ��� ������ �����������.
     *
     * @param coord ����������, ����� ��������� �������� ������� ��������
     *        ���������� ������ ���������� � ��������� [0, ������].
     */
    public double getCoord(double rangeMin, double rangeMax,
        int size, int coord) {

        assert size > 0;
        assert coord >= 0 && coord < size;

        double range = rangeMax - rangeMin;
        return rangeMin + (range * (double) coord / (double) size);
    }

    /**
     * ������������� ��������� �������������, ����� ��������� ��������� ��������, ����������
     * ��� ������������� ��������.
     */
    public void getInitialRange(Rectangle2D.Double range) {};
    public int numIterations(double x, double y) { return 0; };

    /**
     * ��������� ������� �������� � ������� � ��������� �����������, 
     * � ����� ��� ���������� ��� ���������� � ������� ���������� ������������ ���������������.
     */
    public static void recenterAndZoomRange(Rectangle2D.Double range,
        double centerX, double centerY, double scale) {

        double newWidth = range.width * scale;
        double newHeight = range.height * scale;

        range.x = centerX - newWidth / 2;
        range.y = centerY - newHeight / 2;
        range.width = newWidth;
        range.height = newHeight;
    }
}
