package passwordGenerator;
public class GeneratorRunner {
    public static void main(String[] args) {
        Generator generator = new Generator(Complexity.MIN, 7);
        System.out.println(generator.generate());
        generator = new Generator(Complexity.MID, 10);
        System.out.println(generator.generate());
        generator = new Generator(Complexity.MAX, 15);
        System.out.println(generator.generate());
    }
}
