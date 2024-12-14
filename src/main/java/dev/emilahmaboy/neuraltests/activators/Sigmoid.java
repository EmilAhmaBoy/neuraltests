package dev.emilahmaboy.neuraltests.activators;

public class Sigmoid extends Activator {
    @Override
    public double calculate(double value) {
        return 1 / (1 + Math.pow(Math.E, -value));
    }

    @Override
    public double derivative(double value) {
        double calc = this.calculate(value);
        return calc * (1 - calc);
    }
}
