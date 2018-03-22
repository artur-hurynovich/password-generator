package passwordGenerator;
import javax.swing.*;
public class GeneratorRunner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PasswordGeneratorFrame::new);
    }
}
