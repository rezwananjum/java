package course_management;

/**
 *
 * @author Tousif
 */
public class RegisterCourseController {
    private Registration reg;
    
    public RegisterCourseController() {
        reg = new Registration();
    }
    
    public void makeNewRegistration(){
        reg = new Registration();
    }
    public void addCourse(String id) {
        reg.addCourse(new CourseFactory().getCourse(id));
    }
    public Registration getRegistration() {
        return reg;
    }
    public Course getCourse(String id){
        return reg.getCourse(id);
    }
}
