package LinearAlgebra;

import java.util.Random;

public class Vector {

    private double[] data;

    public Vector(int n) {
        data = new double[n];
        Random r = new Random();
        for (int i = 0; i < n; i++)
            data[i] = r.nextInt(10);
    }

    public Vector(int n, int value) {
        data = new double[n];
        for (int i = 0; i < n; i++)
            data[i] = value;
    }

    public Vector(double[] data) {
        this.data = data;
    }

    public int size() {
        return data.length;
    }

    public double get(int i) {
        return data[i];
    }

    public void set(int i, double value) {
        data[i] = value;
    }

    public Vector add(Vector other) {
        if (size() != other.size())
            throw new IllegalArgumentException("Vector sizes don't match");
        Vector result = new Vector(size());
        for (int i = 0; i < size(); i++)
            result.set(i, get(i) + other.get(i));
        return result;
    }

    public Vector subtract(Vector other) {
        if (size() != other.size())
            throw new IllegalArgumentException("Vector sizes don't match");
        Vector result = new Vector(size());
        for (int i = 0; i < size(); i++)
            result.set(i, get(i) - other.get(i));
        return result;
    }

    public Vector multiply(double scalar) {
        Vector result = new Vector(size());
        for (int i = 0; i < size(); i++)
            result.set(i, get(i) * scalar);
        return result;
    }

    public double dot(Vector other) {
        if (size() != other.size())
            throw new IllegalArgumentException("Vector sizes don't match");
        double result = 0;
        for (int i = 0; i < size(); i++)
            result += get(i) * other.get(i);
        return result;
    }

    public double norm() {
        return Math.sqrt(dot(this));
    }

    public Vector normalize() {
        return multiply(1 / norm());
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < size(); i++)
            result += String.format("%f ", get(i));
        result += "]";
        return result;
    }
    
}
