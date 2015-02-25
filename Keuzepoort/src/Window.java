import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame {
    private JLabel questionLabel, trueLabel, falseLabel;
    private Color color;

    public Window() {
        setTitle("Keuzepoort software - by IGNE 2015");
        setLayout(new FlowLayout());
        /* color: 0x3498db */

        questionLabel = new JLabel("");
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        questionLabel.setVerticalAlignment(JLabel.CENTER);
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setFont(new Font("Roboto", Font.BOLD, 50)); 
        add(questionLabel);
 		
 		trueLabel = new JLabel("");
 		//add(trueLabel);

 		falseLabel = new JLabel("");
 		//add(falseLabel);
        color = new Color(52,152,219);
        getContentPane().setBackground(color); 
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setQuestionLabel(String s) {
    	questionLabel.setText(s);
    }

    public void setTrueLabel(String s) {
    	trueLabel.setText(s);
    }

    public void setFalseLabel(String s) {
    	falseLabel.setText(s);
    }
}