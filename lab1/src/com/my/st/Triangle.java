package com.my.st;

public class Triangle {
    public enum Type{OBTUSE, RIGHT, SHARP,ILLEGAL}

    double[] edge = new double[3];
    Type type;

    public Triangle(double a, double b, double c){
        edge[0] = a;
        edge[1] = b;
        edge[2] = c;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                if(edge[j] > edge[j+1]){
                    double tempnum = edge[j];
                    edge[j] = edge[j + 1];
                    edge[j + 1] = tempnum;
                }
            }
        }

        if(edge[0] + edge[1] <= edge[2]) type = Type.ILLEGAL;
        else {
            double res = edge[0] * edge[0] + edge[1] * edge[1] - edge[2] * edge[2];
            if (res > Double.MIN_VALUE) type = Type.SHARP;
            else if (res < -Double.MIN_VALUE) type = Type.OBTUSE;
            else type = Type.RIGHT;
        }
    }

    public Type getType() {
        return type;
    }
}
