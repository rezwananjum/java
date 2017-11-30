package course_management;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Tousif
 */
public class RegistrationTable extends JPanel {
    
    private int rowCount = 1;
    private GridLayout grid;
    
    public RegistrationTable() {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1, 6,10, 10));
        titlePanel.setBorder(new LineBorder(Color.RED, 2));
        titlePanel.add(new JLabel(" SL#"));
        titlePanel.add(new JLabel("Course ID"));
        titlePanel.add(new JLabel("Course Title"));
        titlePanel.add(new JLabel("Cradit"));
        titlePanel.add(new JLabel("Tution / Cradit"));
        titlePanel.add(new JLabel("Sub Total"));
        titlePanel.setPreferredSize(new Dimension(700, 50));
        
        grid = new GridLayout(rowCount, 1);
        setLayout(grid);
        setBorder(new LineBorder(Color.GRAY,4));
        add(titlePanel);
    }
    
    public void addCourse(Course c) {
        JPanel row = new JPanel();
        row.setLayout(new GridLayout(1, 6, 10, 10));
        row.setBorder(new LineBorder(Color.GRAY, 1));
        row.add(new JLabel(" " + rowCount));
        row.add(new JLabel(c.getID()));
        row.add(new JLabel(c.getTitle()));
        row.add(new JLabel(String.valueOf(c.getCredit())));
        row.add(new JLabel(String.valueOf(c.getTutionPerCredit())));
        row.add(new JLabel(String.valueOf(c.getSubTotal())));
        
        grid.setRows(++rowCount);
        add(row);
        repaint();
    }
    
}
