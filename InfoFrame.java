package passwordGenerator;
import javax.swing.*;
import java.awt.*;
class InfoFrame extends JDialog {
    private JTextArea aboutTextArea;
    private JButton okButton;
    InfoFrame(Frame owner){
        super(owner, "Information", ModalityType.APPLICATION_MODAL);
        getContentPane().setLayout(new FlowLayout());
        createComponents();
        fillFrame();
        createFrame();
    }
    private void createComponents(){
        aboutTextArea = new JTextArea();
        aboutTextArea.setSize(190, 150);
        aboutTextArea.setText("The application generates passwords with 3 \ncomplexity levels - " +
                "MIN (only letters in lower \ncase), MID (letters in lower case and \nnumbers) and " +
                "MAX (letters in both cases and \nnumbers). " +
                "And password complexity and \npassword length must be set by user." +
                "\nAuthor: Artur Hurynovich. 2018");
        aboutTextArea.setEditable(false);
        okButton = new JButton("OK");
        okButton.addActionListener((actionEvent) -> setVisible(false));
    }
    private void fillFrame(){
        add(aboutTextArea);
        add(okButton);
    }
    private void createFrame(){
        getContentPane().setLayout(new FlowLayout());
        setSize(270, 180);
        setLocation(150, 150);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
