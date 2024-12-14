import dev.emilahmaboy.neuraltests.activators.Sigmoid;
import dev.emilahmaboy.neuraltests.tests.xor.XorModel;

public class Test {
    public static void main(String[] args) {
        XorModel model = new XorModel(2, 2, new Sigmoid());
        System.out.println(model.xor(false, true));
    }
}
