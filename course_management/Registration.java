package course_management;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Registration {
    private final LinkedList<Course> courseList = new LinkedList<>();
    
    
    public LinkedList<Course> getCourseList(){
        return new LinkedList<>(courseList);
    }
    
    public void addCourse(Course c){
        courseList.add(c);
    }
    public Course getCourse(String id) {
        for(int i = 0; i < courseList.size(); i++)
            if (courseList.get(i).getID().equals(id))
                return courseList.get(i);
        
        return null;
                
    }
    public int getTotal() {
        int total = 0;
        for(int i = 0; i < courseList.size(); i++)
            total += courseList.get(i).getSubTotal();
    
        return total;
    }
}
