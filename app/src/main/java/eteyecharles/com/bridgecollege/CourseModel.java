package eteyecharles.com.bridgecollege;

/**
 * Created by CHARL on 04-Apr-18.
 */

public class CourseModel {

    private int courseNumber;
    private String courseTitle;
    private  String courseDescription;
    private  double courseCredits;

    public CourseModel(int courseNumber, String courseTitle, String courseDescription, double courseCredits) {
        this.courseNumber = courseNumber;
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.courseCredits = courseCredits;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public double getCourseCredits() {
        return courseCredits;
    }

    @Override
    public String toString() {
        return courseTitle;}
}
