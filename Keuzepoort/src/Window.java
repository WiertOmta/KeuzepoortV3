import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame {
    private JLabel questionLabel, trueLabel, falseLabel;
 
    public Window() {
        setLayout(new FlowLayout());
 
        questionLabel = new JLabel("");
        add(questionLabel);
 		
 		trueLabel = new JLabel("");
 		add(trueLabel);

 		falseLabel = new JLabel("");
 		add(falseLabel);

        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public setQuestionLabel(String s) {
    	questionLabel.setText(s);
    }

    public setTrueLabel(String s) {
    	trueLabel.setText(s);
    }

    public setFalseLabel(String s) {
    	falseLabel.setText(s);
    }
}