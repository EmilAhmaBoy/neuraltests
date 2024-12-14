package dev.emilahmaboy.neuraltests.networks;

import dev.emilahmaboy.neuraltests.activators.Activator;

import java.util.ArrayList;
import java.util.Arrays;

public class FeedforwardNetwork extends Network {
    private final ArrayList<double[][]> weights = new ArrayList<>();
    private final Activator activator;

    public FeedforwardNetwork(
            int inputNeurons,
            int hiddenNeurons,
            int outputNeurons,
            int hiddenLayers,
            Activator activator
    ) {
        double[][] inputNeuronsWeights = new double[inputNeurons][hiddenLayers > 0 ? hiddenNeurons : outputNeurons];
        weights.add(inputNeuronsWeights);
        for (int i = 0; i < hiddenLayers; i++) {
            double[][] layer = new double[hiddenNeurons][i >= hiddenLayers - 1 ? outputNeurons : hiddenNeurons];
            weights.add(layer);
        }
        this.activator = activator;
        this.shuffle();
    }

    public void shuffle() {
        for (double[][] layer : weights) {
            for (double[] neuron : layer) {
                for (int synapseI = 0; synapseI < neuron.length; synapseI++) {
                    neuron[synapseI] = Math.random() * 2 - 1;
                }
            }
        }
    }

    public double[] push(double[] input) {
        // Проходимся по слоям нейронной сети
        for (double[][] layerNeurons : weights) {
            double[] output = new double[layerNeurons[0].length];  // Подготавливаем выходные данные для текущего слоя

            // Проходимся по всем нейронам слоя
            for (int neuron = 0; neuron < layerNeurons.length; neuron++) {
                double[] synapses = layerNeurons[neuron];

                // Проходимся по всем синапсам нейрона
                for (int synapse = 0; synapse < synapses.length; synapse++) {
                    // Получаем вес текущего синапса
                    double weight = synapses[synapse];
                    // Добавляем значение к нейрону из выходных данных для текущего слоя
                    output[synapse] += input[neuron] * weight;
                }
            }

            // Применяем функцию активации к выходным данным
            for (int i = 0; i < output.length; i++) {
                output[i] = activator.calculate(output[i]);
            }

            input = output;  // Выходные данные для текущего слоя становятся входными данными для следующего слоя
            System.out.println(Arrays.toString(output));
        }
        return input;
    }
}
