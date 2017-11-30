package course_management;
import java.util.*;

/**
 *
 * @author user
 */
public class CourseFactory {
    private final LinkedList<Course> cList;
    
    public CourseFactory() {
        cList = new LinkedList<>();
        
        cList.add(new Course("CSE327", "Software Engineering", 3, 4500));
        
        cList.add(new Course("CSE348", "Artificial Intelligence", 3, 4500));
        
        cList.add(new Course("CSE482", "Web Technology", 3, 4500));
        
        cList.add(new Course("CSE468", "Computer Vision", 3, 4500));
        
        cList.add(new Course("CSE331", "Assembly Language", 3, 4500));
        
        cList.add(new Course("CSE231", "Digital Logic", 3, 4500));
        
        cList.add(new Course("CSE232", "Computer Architecture", 3, 4500));
        
        cList.add(new Course("CSE115", "Computer Concepts", 3, 4500));
    }
    
    Course getCourse(String ID){
       Course c = null;
       for(int i = 0; i < cList.size(); i++) {
           if(cList.get(i).getID().equals(ID)) {
               c = cList.get(i);
               break;
           }
       }
       return c;
    }
}