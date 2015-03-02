import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import javax.swing.ImageIcon;
import java.util.*;

public class Window extends JFrame {
    private JLabel questionLabel, trueLabel, falseLabel, banner, line;
    private Color color;
    private ArrayList<Color> colorList;
    private Random randomGenerator;
    private JPanel panel, subPanel;

    public Window() {
        setTitle("Keuzepoort software - by IGNE 2015");
        setLayout(new BorderLayout());

        questionLabel = new JLabel("");
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        questionLabel.setVerticalAlignment(JLabel.BOTTOM);
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setFont(new Font("Roboto Condensed", Font.BOLD, 70)); 

        banner = new JLabel(new ImageIcon("banner.png"));
        banner.setHorizontalAlignment(JLabel.LEFT);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(banner);
        panel.add(questionLabel);

        add(panel, BorderLayout.SOUTH);
 		
        randomGenerator = new Random();

        colorList = new ArrayList<Color>();
        colorList.add(new Color(161,38,131));
        colorList.add(new Color(27,172,75));
        colorList.add(new Color(4,116,189));
        colorList.add(new Color(23,173,172));
        colorList.add(new Color(108,140,199));
        colorList.add(new Color(166,206,56));
        colorList.add(new Color(234,55,128));
        colorList.add(new Color(222,146,192));
        colorList.add(new Color(120,205,210));
        colorList.add(new Color(237,62,61));
        colorList.add(new Color(241,112,36));
        colorList.add(new Color(132,199,143));

        Color color = colorList.get(randomGenerator.nextInt(colorList.size()));
        getContentPane().setBackground(color); 
        panel.setBackground(color);
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

    public void setRandomBackgroundColor() {
        Color color = colorList.get(randomGenerator.nextInt(colorList.size()));
        getContentPane().setBackground(color);
        panel.setBackground(color);
    }
}