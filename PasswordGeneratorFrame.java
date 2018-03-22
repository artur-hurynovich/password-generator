package passwordGenerator;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
class PasswordGeneratorFrame extends JFrame {
    private JLabel passwordLength;
    private JLabel passwordComplexity;
    private JComboBox<Integer> quantity;
    private JRadioButton min;
    private JRadioButton mid;
    private JRadioButton max;
    private JButton generate;
    private JLabel password;
    private JButton copyToClipboard;
    private JButton exit;
    private JPanel generationPanel;
    private JSeparator separator;
    private JPanel displayPanel;
    private InfoFrame infoFrame;
    PasswordGeneratorFrame(){
        getContentPane().setLayout(new FlowLayout());
        generationPanel = new JPanel();
        generationPanel.setLayout(new BoxLayout(generationPanel, BoxLayout.Y_AXIS));
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        createMenu();
        createComponents();
        fillFrame();
        createFrame();
    }
    private void createMenu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuAbout = new JMenu("About");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener((actionEvent) -> System.exit(0));
        JMenuItem info = new JMenuItem("Info");
        info.addActionListener((actionEvent) -> {
            if (infoFrame == null) infoFrame = new InfoFrame(this);
            infoFrame.setVisible(true);
        });
        menuFile.add(exit);
        menuAbout.add(info);
        menuBar.add(menuFile);
        menuBar.add(menuAbout);
        setJMenuBar(menuBar);
    }
    private void createComponents(){
        passwordLength = new JLabel("Password Length:");
        quantity = new JComboBox<>();
        for (int i = 0; i < 20; i++) quantity.addItem(i + 1);
        quantity.setSelectedIndex(9);
        quantity.setAlignmentX(Component.LEFT_ALIGNMENT);
        passwordComplexity = new JLabel("Password Complexity:");
        min = new JRadioButton("MIN");
        min.setSelected(true);
        mid = new JRadioButton("MID");
        max = new JRadioButton("MAX");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(min);
        buttonGroup.add(mid);
        buttonGroup.add(max);
        generate = new JButton("Generate");
        generate.addActionListener((actionEvent) -> {
            Complexity complexity;
            if (min.isSelected()) complexity = Complexity.MIN;
            else if (mid.isSelected()) complexity = Complexity.MID;
            else complexity = Complexity.MAX;
            int count = (int)quantity.getSelectedItem();
            Generator generator = new Generator(complexity, count);
            password.setText(generator.generate());
            copyToClipboard.setEnabled(true);
        });
        password = new JLabel("PASSWORD");
        password.setAlignmentX(Component.CENTER_ALIGNMENT);
        copyToClipboard = new JButton("Copy To Clipboard");
        copyToClipboard.setMaximumSize(new Dimension(180, 25));
        copyToClipboard.addActionListener((actionEvent) ->
                Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(new StringSelection(password.getText()), null));
        copyToClipboard.setAlignmentX(Component.CENTER_ALIGNMENT);
        copyToClipboard.setEnabled(false);
        exit = new JButton("Exit");
        exit.addActionListener((actionEvent) -> System.exit(0));
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setPreferredSize(new Dimension(1, 160));
    }
    private void fillFrame(){
        generationPanel.add(passwordLength);
        generationPanel.add(Box.createVerticalStrut(5));
        generationPanel.add(quantity);
        generationPanel.add(Box.createVerticalStrut(5));
        generationPanel.add(passwordComplexity);
        generationPanel.add(min);
        generationPanel.add(mid);
        generationPanel.add(max);
        generationPanel.add(generate);
        displayPanel.add(password);
        displayPanel.add(Box.createVerticalStrut(5));
        displayPanel.add(copyToClipboard);
        displayPanel.add(Box.createVerticalStrut(5));
        displayPanel.add(exit);
        add(generationPanel);
        add(separator);
        add(displayPanel);
    }
    private void createFrame(){
        setTitle("Password Generator");
        setSize(295, 230);
        setLocation(100, 100);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
