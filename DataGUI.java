import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class DataGUI extends JFrame {
    private JTextField inputField;
    private JTextArea resultsArea;
    private JButton findColor;
    private JButton countColor;

    private FileOperator fileOperator;

    public DataGUI() {
        fileOperator= new FileOperator("colors.txt");
        setTitle("Bird Data Analyzer");
        setSize(600, 600);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField= new JTextField(20);
        resultsArea= new JTextArea(10, 30);
        findColor= new JButton("Find By Color");
        countColor=new JButton("Count By Color");

        add(inputField);
        add(findColor);
        add(countColor);
        add(resultsArea);

        findColor.addActionListener(e->analyzeByColor());
        countColor.addActionListener(e->countColor());


        setVisible(true);
    }


    public void analyzeByColor() {
        // Implement your analysis logic here
        String input = inputField.getText();
        String birds=DataAnalyzer.birdsWithColor(input) ;

        // Call static method from DataAnalyzer or perform your analysis
        resultsArea.append("Analyzing by Color: " + birds+ "\n");
    }




    public void countColor() {
        resultsArea.setText("");
        String input = inputField.getText();
        // Implement your logic here
        resultsArea.append("Getting Most Common Color..."+DataAnalyzer.countWithColor(input) +"\n");
    }

    public static void main(String[] args) {

        new DataGUI();
    }
}
