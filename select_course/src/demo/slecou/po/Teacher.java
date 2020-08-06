package demo.slecou.po;

public class Teacher {

	private Integer teacherID ;
	private String teacherName;
	private String technology;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(Integer teacherID, String teacherName, String technology) {
		super();
		this.teacherID = teacherID;
		this.teacherName = teacherName;
		this.technology = technology;
	}
	@Override
	public String toString() {
		return " teacherID=" + teacherID + ", teacherName=" + teacherName + ", technology=" + technology ;
	}
	public Integer getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(Integer teacherID) {
		this.teacherID = teacherID;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	
}
