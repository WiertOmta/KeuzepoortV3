import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame {
    private JLabel questionLabel, trueLabel, falseLabel;
 
    public Window() {
        setTitle("Keuzepoort software - by IGNE 2015");
        setLayout(new FlowLayout());
 
        questionLabel = new JLabel("");
        add(questionLabel);
 		
 		trueLabel = new JLabel("");
 		add(trueLabel);

 		falseLabel = new JLabel("");
 		add(falseLabel);

        getContentPane().setBackground(Color.GRAY); 
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