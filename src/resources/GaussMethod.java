package resources;


import java.util.ArrayList;
import java.util.Random;

public class GaussMethod {

    private int X1;
    private int X2;
    private int X3;
    private int X4;
    private int X5;
    private int X6;
    private int X7;


    private double x1 = 0;
    private double x2 = 0;
    private double x3 = 0;
    private double x4 = 0;
    private double x5 = 0;
    private double x6 = 0;
    private double x7 = 0;


    private int maxX1;
    private int maxX2;
    private int maxX3;
    private int maxX4;
    private int maxX5;
    private int maxX6;
    private int maxX7;

    private int minX1;
    private int minX2;
    private int minX3;
    private int minX4;
    private int minX5;
    private int minX6;
    private int minX7;
    private Random random = new Random();


    public void setMaxMinX1(int maxX1, int minX1) {
        this.maxX1 = maxX1;
        this.minX1 = minX1;
    }

    public void setMaxMinX2(int maxX2, int minX2) {
        this.maxX2 = maxX2;
        this.minX2 = minX2;
    }

    public void setMaxMinX3(int maxX3, int minX3) {
        this.maxX3 = maxX3;
        this.minX3 = minX3;
    }

    public void setMaxMinX4(int maxX4, int minX4) {
        this.maxX4 = maxX4;
        this.minX4 = minX4;
    }

    public void setMaxMinX5(int maxX5, int minX5) {
        this.maxX5 = maxX5;
        this.minX5 = minX5;
    }

    public void setMaxMinX6(int maxX6, int minX6) {
        this.maxX6 = maxX6;
        this.minX6 = minX6;
    }

    public void setMaxMinX7(int maxX7, int minX7) {
        this.maxX7 = maxX7;
        this.minX7 = minX7;
    }

    public ArrayList calculate(double x1, double x2, double x3, double x4,
                               double x5, double x6, double x7) {
        ArrayList arrayList = new ArrayList();
        if (this.x1 != x1) {
            this.x1 = x1;
            X1 = random.nextInt(maxX1 - minX1) + minX1;
        }

        if (this.x2 != x2) {
            this.x2 = x2;
            X2 = random.nextInt(maxX2 - minX2) + minX2;
        }
        if (this.x3 != x3) {
            this.x3 = x3;
            X3 = random.nextInt(maxX3 - minX3) + minX3;
        }
        if (this.x4 != x4) {
            this.x4 = x4;
            X4 = random.nextInt(maxX4 - minX4) + minX4;
        }
        if (this.x5 != x5) {
            this.x5 = x5;
            X5 = random.nextInt(maxX5 - minX5) + minX5;
        }
        if (this.x6 != x6) {
            this.x6 = x6;
            X6 = random.nextInt(maxX6 - minX6) + minX6;
        }
        if (this.x7 != x7) {
            this.x7 = x7;
            X7 = random.nextInt(maxX7 - minX7) + minX7;
        }
        arrayList.add(X1);
        arrayList.add(X2);
        arrayList.add(X3);
        arrayList.add(X4);
        arrayList.add(X5);
        arrayList.add(X6);
        arrayList.add(X7);
        return arrayList;
    }
}
