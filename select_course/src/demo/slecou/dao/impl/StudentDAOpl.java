package demo.slecou.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import demo.slecou.dao.StudentDAO;
import demo.slecou.po.Admin;
import demo.slecou.po.Course;
import demo.slecou.po.Student;
import demo.slecou.util.BaseDAO;

public class StudentDAOpl extends BaseDAO implements StudentDAO {

	@Override
	public int saveStudent(String studentName,String studentClass) {
		// TODO Auto-generated method stub
		// 新增学生
				PreparedStatement pstmt = null;
				ResultSet rs=null;
				try {
					
					String sql = "insert into student(studentName,studentClass) values(?,?)";
					pstmt = getConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, studentName);
					pstmt.setString(2, studentClass);
					pstmt.executeUpdate();
					rs = pstmt.getGeneratedKeys();
					if(rs.next()){
						return rs.getInt(1);
					}
					
				} catch (Exception e) {	//找不到文件的异常
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					close(null, pstmt, rs);
				}
				return -1;
		}

	@Override
	public Student Login(int studentID) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Student student=null;
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM student WHERE studentID = ?" ;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, studentID);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				student = new Student();
				student.setStudentID(rs.getInt("studentID"));
				student.setStudentName(rs.getString("studentName"));
				student.setStudentClass(rs.getString("studentClass"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(null, pstmt, rs);
		}
		return student;
	}

	
	@Override
	public List<Course> courseBystudentID(int studentID) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Course course = null;
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM stucou,course WHERE stucou.`courseID`=course.`courseID` AND stucou.studentID=?;" ;
		List<Course> clist = new ArrayList<Course>();
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, studentID);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				course = new Course();
				course.setCourseID(rs.getInt("courseID"));
				course.setCourseName(rs.getString("courseName"));
				course.setCourseHour(rs.getInt("courseHour"));
				course.setTeacherID(rs.getInt("teacherID"));
				clist.add(course);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(null, pstmt, rs);
		}
		return clist;
	}

	@Override
	public List<Course> listCourse(String teacherName, String courseName) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		// TODO Auto-generated method stub
		
		StringBuffer sql =new StringBuffer("SELECT course.`courseID`,course.`courseName`,course.`courseHour`,course.`teacherID`"
				+ " FROM teacher,course  WHERE teacher.`teacherID` = course.`teacherID`"); 
		if(teacherName!=null && !teacherName.equals("")){
			sql.append("AND teacher.teacherName LIKE '%"+teacherName+"%'");
		}
		if(courseName!=null && !courseName.equals("")){
			sql.append("  AND course.`courseName` LIKE '%"+courseName+"%';");
		}

		List<Course> clist = new ArrayList<Course>();
		try {
			pstmt = getConn().prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				Course course = new Course();
				course.setCourseID(rs.getInt("courseID"));
				course.setCourseName(rs.getString("courseName"));
				course.setCourseHour(rs.getInt("courseHour"));
				course.setTeacherID(rs.getInt("teacherID"));
				clist.add(course);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(null, pstmt, rs);
		}
		return clist;
	}

	@Override
	public int chooseCourseByID(int courseID,int studentID) {
		// TODO Auto-generated method stub
		// 新增课程
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			String sql = "INSERT INTO stucou(studentID,courseID) VALUES(?,?)";
			pstmt = getConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, studentID);
			pstmt.setInt(2, courseID);
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (Exception e) {	//找不到文件的异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(null, pstmt, rs);
		}
		return -1;

	}

	@Override
	public int panduan(int courseID, int studentID) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			String sql = "SELECT * FROM stucou WHERE studentID=? and courseID=?;";
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, studentID);
			pstmt.setInt(2, courseID);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (Exception e) {	//找不到文件的异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(null, pstmt, rs);
		}
		return 0;
	}

	@Override
	public Student showStudent(int studentID) {
		// TODO Auto-generated method stub
		String sql = "select * from student where studentID=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Student student = new Student();
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, studentID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				student.setStudentID(rs.getInt("studentID"));
				student.setStudentName(rs.getString("studentName"));
				student.setStudentClass(rs.getString("studentClass"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(null, pstmt, rs);
		}
		return student;
	}


	


}
