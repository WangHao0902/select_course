package demo.slecou.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.slecou.dao.TeacherDAO;
import demo.slecou.po.Course;
import demo.slecou.po.Student;
import demo.slecou.po.Teacher;
import demo.slecou.util.BaseDAO;

public class TeacherDAOpl extends BaseDAO implements TeacherDAO {

	@Override
	public List<Teacher> showAll() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Teacher teacher = null;
		// TODO Auto-generated method stub
		String sql = "SELECT teacherID,teacherName,technology FROM teacher " ;
		List<Teacher> tlist = new ArrayList<Teacher>();
		try {
			pstmt = getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				teacher = new Teacher();
				teacher.setTeacherID(rs.getInt("teacherID"));
				teacher.setTeacherName(rs.getString("teacherName"));
				teacher.setTechnology(rs.getString("technology"));

				tlist.add(teacher);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(null, pstmt, rs);
		}
		return tlist;
	}

	@Override
	public int saveTeacher(String teacherName, String technology) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			
			String sql = "insert into teacher(teacherName,technology) values(?,?)";
			pstmt = getConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, teacherName);
			pstmt.setString(2, technology);
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
	public int updateTeacheryn(int teacherID) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			String sql = "SELECT * FROM teacher WHERE teacherID=?;";
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, teacherID);
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
	public int update(Teacher teacher) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		int num=0;
		// TODO Auto-generated method stub
		String sql = "UPDATE teacher set teacherName=?, technology=? where teacherID=?" ;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1,teacher.getTeacherName());
			pstmt.setString(2, teacher.getTechnology());
			pstmt.setInt(3, teacher.getTeacherID());
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
	public int removeTeacher(int teacherID) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int num = 0;
		try {
			getConn().setAutoCommit(false);
			String sql1 ="delete from teacher where teacherid =?";
			String sql2 ="delete from stucou where courseid =(select courseid from course where teacherid=?)";
			String sql3 ="delete from course where teacherid =?";
			pstmt = getConn().prepareStatement(sql2);
			pstmt.setInt(1, teacherID);
			pstmt.executeUpdate();
			
			pstmt = getConn().prepareStatement(sql3);
			pstmt.setInt(1, teacherID);
			pstmt.executeUpdate();
			
			pstmt = getConn().prepareStatement(sql1);
			pstmt.setInt(1, teacherID);
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
	public List<Student> lookstu(int teacherID) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Student student=null;
		// TODO Auto-generated method stub
		String sql = "SELECT DISTINCT stu.* FROM student AS stu,course AS c,stucou AS s"
				+ " WHERE stu.`studentid` IN(SELECT studentid FROM stucou WHERE "
				+ "courseid=any(SELECT courseid FROM course WHERE teacherid = ?))";

		List<Student> slist = new ArrayList<Student>();
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, teacherID);
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
