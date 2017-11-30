package course_management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author user
 */
public class RegistrationJframe extends JFrame {
    
    private  RegisterCourseController rcc;
    
    private final JButton jbt_newRegistration;
    private final JButton jbt_addCourse;
    private final TextField tf_courseID;
    private  RegistrationTable courseTable;
    private  JLabel total;
    
    public static void main(String[] args) {
        RegisterCourseController regController = new RegisterCourseController();
        //regController.addCourse("CSE327");
        //System.out.print(regController.getCourse("CSE327").getTitle() + "\n");
        
        RegistrationJframe rf = new RegistrationJframe();
        //rf.courseTable.addCourse(regController.getCourse("CSE327"));
    }
  
    public RegistrationJframe() {
        
        rcc = new RegisterCourseController();
        
        this.setTitle("Course Rrgistration");
        this.setLocationRelativeTo(null);
        this.setLocation(50, 50);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3, 1, 5, 5));
        
        jbt_newRegistration = new JButton("New Registration");
        jbt_newRegistration.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                remove(courseTable);
                
                courseTable = new RegistrationTable();
                
                add(courseTable, BorderLayout.CENTER);
                rcc = new RegisterCourseController();
                total.setText("0");
                repaint();
                pack();
            }
        });
        
        jbt_addCourse = new JButton("Add Course");
        jbt_addCourse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String id = tf_courseID.getText();
                Course c = null;
                                
                if(id != null && new CourseFactory().getCourse(id) != null) {
                    rcc.addCourse(id);
                    c = rcc.getCourse(id);
                }
                if(c != null) {
                    courseTable.addCourse(c);
                    total.setText(String.valueOf(rcc.getRegistration().getTotal()));
                }
                pack();
                //System.out.println(rcc.getCourse(id));
                
            }
        });
        
        tf_courseID = new TextField("Course ID");
        
        topPanel.add(jbt_newRegistration);
        topPanel.add(tf_courseID);
        topPanel.add(jbt_addCourse);

        courseTable = new RegistrationTable();
        
        JPanel bottomPanel = new JPanel();
        //bottomPanel.setLayout(new GridLayout(1, 2, 10, 5));
        
        bottomPanel.add(new JLabel("total: "));
        
        total = new JLabel("0");
        bottomPanel.add(total);
        
        this.add(topPanel, BorderLayout.NORTH);
        this.add(courseTable, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.EAST);
        this.pack();
        this.setVisible(true);
    }
    
}
