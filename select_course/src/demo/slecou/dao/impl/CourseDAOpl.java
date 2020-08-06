package demo.slecou.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.slecou.dao.CourseDAO;
import demo.slecou.po.Course;
import demo.slecou.po.Student;
import demo.slecou.util.BaseDAO;

public class CourseDAOpl extends BaseDAO implements CourseDAO {

	@Override
	public List<Course> showAll() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Course course = null;
		// TODO Auto-generated method stub
		String sql = "SELECT courseID,courseName,courseHour,teacherID FROM course " ;
		List<Course> clist = new ArrayList<Course>();
		try {
			pstmt = getConn().prepareStatement(sql);
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
	public int saveCourse(String courseName, int courseHour, int teacherID) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			
			String sql = "insert into course(courseName,courseHour,teacherID) values(?,?,?)";
			pstmt = getConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, courseName);
			pstmt.setInt(2, courseHour);
			pstmt.setInt(3, teacherID);
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
		return 0;
	}

	@Override
	public int updateCourseyn(int courseID) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			String sql = "SELECT * FROM course WHERE courseID=?;";
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, courseID);
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
	public int update(Course course) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		int num=0;
		// TODO Auto-generated method stub
		String sql = "UPDATE course set courseName=?, courseHour=?,"
				+ " teacherID=? where courseID=?" ;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, course.getCourseName());
			pstmt.setInt(2, course.getCourseHour());
			pstmt.setInt(3, course.getTeacherID());
			pstmt.setInt(4, course.getCourseID());
			num = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(null, pstmt, null);
		}
		
		return num;
	}

	@Override
	public int removeCourse(int courseID) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int num = 0;
		try {
			getConn().setAutoCommit(false);
			String stusql="delete from stucou where courseID = ?";
			String sql = "delete from course where courseID = ?";
			pstmt = getConn().prepareStatement(stusql);
			pstmt.setInt(1, courseID);
			pstmt.executeUpdate();
			
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, courseID);
			num = pstmt.executeUpdate();
			getConn().commit();
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
				try {
					getConn().rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			e.printStackTrace();
		}finally {
			close(null, pstmt, null);
		}
		return num;
	}

	@Override
	public List<Student> lookstu(int courseID) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Course course = null;
		Student student=null;
		// TODO Auto-generated method stub
		String sql = "SELECT student.`studentID`,student.`studentName`,student.`studentClass` "
				+ "FROM stucou,student "
				+ "WHERE stucou.`studentID`=student.`studentID` AND stucou.`courseID`=?;" ;
		List<Student> slist = new ArrayList<Student>();
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, courseID);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				student = new Student();
				student.setStudentID(rs.getInt("studentID"));
				student.setStudentName(rs.getString("studentName"));
				student.setStudentClass(rs.getString("studentClass"));
				slist.add(student);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(null, pstmt, rs);
		}
		return slist;
	}

}
