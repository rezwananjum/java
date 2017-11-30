package package course_management;;

public class Course {
    
    private String id;
    private String title;
    private int credit;
    private int tutionPerCredit;
    
    public Course(String id, String title, int credit, int tutionPerCredit) {
        this.id = id;
        this.title = title;
        this.credit = credit;
        this.tutionPerCredit = tutionPerCredit;
    }
    
    
    int getTutionPerCredit() {
        return tutionPerCredit;
    }
    public void setTutionPerCredit(int NewPerCredit) {
        tutionPerCredit = NewPerCredit;
    }
    
    public void setID(String id) {
        this.id = id;
    }
    public String getID() {
        return id;
    }
    
    void setTitle(String title) {
        this.title = title;
    }
    String getTitle() {
        return title;
    }
    
    void setCredit(int credit) {
        this.credit = credit;
    }
    int getCredit() {
        return credit;
    }
    
    int getSubTotal() {
        return credit*tutionPerCredit;
    }
    
}