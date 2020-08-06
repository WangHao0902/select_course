package demo.slecou.po;

public class Course {

	private Integer courseID;
	private String courseName;
	private Integer courseHour;
	private Integer teacherID;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(Integer courseID, String courseName, Integer courseHour, Integer teacherID) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseHour = courseHour;
		this.teacherID = teacherID;
	}
	@Override
	public String toString() {
		return "courseID=" + courseID + ", courseName=" + courseName + ", courseHour=" + courseHour
				+ ", teacherID=" + teacherID ;
	}
	public Integer getCourseID() {
		return courseID;
	}
	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getCourseHour() {
		return courseHour;
	}
	public void setCourseHour(Integer courseHour) {
		this.courseHour = courseHour;
	}
	public Integer getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(Integer teacherID) {
		this.teacherID = teacherID;
	}
}
