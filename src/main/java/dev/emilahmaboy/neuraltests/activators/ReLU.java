package dev.emilahmaboy.neuraltests.activators;

public class ReLU extends Activator {
    @Override
    public double calculate(double value) {
        return Math.max(0, value);
    }

    @Override
    public double derivative(double value) {
        return value >= 0 ? 1 : 0;
    }
}
