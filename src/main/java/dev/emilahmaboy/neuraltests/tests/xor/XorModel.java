package dev.emilahmaboy.neuraltests.tests.xor;

import dev.emilahmaboy.neuraltests.activators.Activator;
import dev.emilahmaboy.neuraltests.model.Model;
import dev.emilahmaboy.neuraltests.networks.FeedforwardNetwork;

public class XorModel extends Model {
    private final FeedforwardNetwork network;

    public XorModel(int hiddenNeurons, int hiddenLayers, Activator activator) {
        this.network = new FeedforwardNetwork(2, hiddenNeurons, 1, hiddenLayers, activator);
    }

    public boolean xor(boolean a, boolean b) {
        return Math.round(this.network.push(new double[] {a ? 1 : 0, b ? 1 : 0})[0]) == 1L;
    }
}
