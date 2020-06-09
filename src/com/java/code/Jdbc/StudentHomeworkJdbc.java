package com.java.code.Jdbc;

import com.java.code.Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJdbc {

    public static void main(String[] args) {
        String a ="1";
        List<StudentHomework> list = selectAll(a);
        for (StudentHomework sthw : list){
            System.out.println(sthw.gethwId());
        }
        Homework hw = showHomeworkDetails(a);
        System.out.println(hw.gethwTitle());
    }

    private static String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=Asia/Shanghai";

    private static String driverName = "com.mysql.cj.jdbc.Driver";


    public static int selectByUsernameAndPassword(String username, String password) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/school?serverTimezone=UTC";
        String user = "root";
        String pwd = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pwd);

            String sql = "select * from user where username=? and password=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1,username);
            pstm.setString(2,password);

            rs = pstm.executeQuery();
            if(rs.next()) return rs.getInt("is_manager");
            else return 2;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 2;
    }

    public static void insertToUsernameAndPassword(String username, String password,int is_manager) {
        Connection con = null;
        PreparedStatement pstm = null;
        String url = "jdbc:mysql://localhost:3306/school?serverTimezone=UTC";
        String user = "root";
        String pwd = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pwd);

            String sql = "insert into user(username,password,is_manager) values(?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1,username);
            pstm.setString(2,password);
            pstm.setInt(3,is_manager);

            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Company selectCompany() {
        Company company = new Company();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/school?serverTimezone=UTC";
        String user = "root";
        String pwd = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pwd);

            String sql = "select * from company where id = 1";
            pstm = con.prepareStatement(sql);

            rs = pstm.executeQuery();

            while(rs.next()){
                company.setAddress(rs.getString("address"));
                company.setName(rs.getString("name"));
                company.setPhone(rs.getString("phone"));
                company.setEmail(rs.getString("email"));
                company.setNature(rs.getString("nature"));
                company.setIntro(rs.getString("intro"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return company;
    }

    public static void updateToCompany(Company company) {
        Connection con = null;
        PreparedStatement pstm = null;
        String url = "jdbc:mysql://localhost:3306/school?serverTimezone=UTC";
        String user = "root";
        String pwd = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pwd);

            String sql = "update company set name=?,address=?,phone=?,email=?,nature=?,intro=? where id= 1" ;
            pstm = con.prepareStatement(sql);
            pstm.setString(1,company.getName());
            pstm.setString(2,company.getAddress());
            pstm.setString(3,company.getPhone());
            pstm.setString(4,company.getEmail());
            pstm.setString(5,company.getNature());
            pstm.setString(6,company.getIntro());

            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean addNotice(Notice notice){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "insert into notice (title,content,sendtime,sender) values(?,?,?,?)";

        int resultSet = 0;
        try (Connection connection = DriverManager.getConnection(url, "root", "123456")) {
            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setString(1,notice.getTitle());
                ps.setString(2,notice.getContent());
                ps.setString(3,notice.getSendtime());
                ps.setString(4,notice.getSender());
                resultSet = ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet > 0;
    }

    public static boolean addMeeting(Meeting meeting){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "insert into meeting (title,content,address,sender,starttime,endtime) values(?,?,?,?,?,?)";

        int resultSet = 0;
        try (Connection connection = DriverManager.getConnection(url, "root", "123456")) {
            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setString(1,meeting.getTitle());
                ps.setString(2,meeting.getContent());
                ps.setString(3,meeting.getAddress());
                ps.setString(4,meeting.getSender());
                ps.setString(5,meeting.getStarttime());
                ps.setString(6,meeting.getEndtime());
                resultSet = ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet > 0;
    }

    public static List<Notice> showNotice(){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "SELECT * FROM notice";

        List<Notice> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, "root", "123456")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        Notice notice = new Notice();
                        notice.setId(resultSet.getInt("id"));
                        notice.setTitle(resultSet.getString("title"));
                        notice.setContent(resultSet.getString("content"));
                        notice.setSendtime(resultSet.getString("sendtime"));
                        notice.setSender(resultSet.getString("sender"));
                        list.add(notice);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    public static Meeting selectMeetingById(int id) {
        Meeting meeting = new Meeting();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/school?serverTimezone=UTC";
        String user = "root";
        String pwd = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pwd);

            String sql = "select * from meeting where id = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,id);

            rs = pstm.executeQuery();

            while(rs.next()){
                meeting.setTitle(rs.getString("title"));
                meeting.setContent(rs.getString("content"));
                meeting.setAddress(rs.getString("address"));
                meeting.setSender(rs.getString("sender"));
                meeting.setStarttime(rs.getString("starttime"));
                meeting.setEndtime(rs.getString("endtime"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return meeting;
    }

    public static void updateToNotice(Notice notice) {
        Connection con = null;
        PreparedStatement pstm = null;
        String url = "jdbc:mysql://localhost:3306/school?serverTimezone=UTC";
        String user = "root";
        String pwd = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pwd);

            String sql = "update notice set title=?,content=?,sendtime=?,sender=? where id= ?" ;
            pstm = con.prepareStatement(sql);
            pstm.setString(1,notice.getTitle());
            pstm.setString(2,notice.getContent());
            pstm.setString(3,notice.getSendtime());
            pstm.setString(4,notice.getSender());
            pstm.setInt(5,notice.getId());

            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void DeleteNotice(int id) {
        Connection con=null;
        PreparedStatement pstmt=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url="jdbc:mysql://localhost:3306/school?serverTimezone=UTC";
            String user="root";
            String password="123456";
            con=DriverManager.getConnection(url, user, password);

            String sql="delete from notice where id=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1, id);

            int result=pstmt.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    /**
     * 从student_homework表读取指定作业id 的所有记录，即某次作业的所有提交记录
     * @return 返回结果list
     */
    public static List<StudentHomework> selectAll(String hw_id) {

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "SELECT * FROM student_homework where hw_id="+hw_id;

        List<StudentHomework> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, "root", "123456")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        StudentHomework sh = new StudentHomework();
                        sh.setsthwId(resultSet.getLong("st_hw_id"));
                        sh.setstId(resultSet.getLong("st_id"));
                        sh.sethwId(resultSet.getLong("hw_id"));
                        sh.sethwTitle(resultSet.getString("hw_title"));
                        sh.sethwContent(resultSet.getString("hw_content"));
                        sh.setsubmitContent(resultSet.getString("submit_content"));
                        sh.setsthwCreateTime(resultSet.getTimestamp("st_hw_create_time"));
                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 向homework表添加作业记录
     * @param homework  将要添加的homework
     * @return true=>成功否则失败
     */
    public static boolean addHomework(Homework homework){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "insert into homework (hw_id,hw_title,hw_content,hw_create_time) values(?,?,?,?)";

        int resultSet = 0;
        try (Connection connection = DriverManager.getConnection(url, "root", "123456")) {
            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setLong(1,homework.gethwId());
                ps.setString(2,homework.gethwTitle());
                ps.setString(3,homework.gethwContent());
                ps.setTimestamp(4,new Timestamp(homework.gethwCreateTime().getTime()));
                resultSet = ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet > 0;
    }

    /**
     * 向student表添加学生
     * @param student 将要添加的student
     * @return true成功否则失败
     */
    public static boolean addStudent(Student student){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "insert into student (st_id,st_name,st_create_time) values(?,?,?)";

        int resultSet = 0;
        try (Connection connection = DriverManager.getConnection(url, "root", "123456")) {
            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setLong(1,student.getstId());
                ps.setString(2,student.getstName());
                ps.setTimestamp(3,new Timestamp(student.getstCreateTime().getTime()));
                resultSet = ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet > 0;
    }

    /**
     *从homework表读取所有作业记录
     * @return  结果list
     */
    public static List<Homework> showHomework(){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "SELECT * FROM homework";

        List<Homework> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, "root", "123456")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        Homework homework = new Homework();
                        homework.sethwId(resultSet.getLong("hw_id"));
                        homework.sethwTitle(resultSet.getString("hw_title"));
                        homework.sethwContent(resultSet.getString("hw_content"));
                        list.add(homework);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    /**
     * 从homework表读取指定id的作业详细内容
     * @param hw_id 作业id
     * @return 作业对象homework
     */
    public static Homework showHomeworkDetails(String hw_id){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "SELECT * FROM homework WHERE hw_id=" + hw_id;

        Homework homework = new Homework();
        try (Connection connection = DriverManager.getConnection(url, "root", "123456")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        homework.sethwId(resultSet.getLong("hw_id"));
                        homework.sethwTitle(resultSet.getString("hw_title"));
                        homework.sethwContent(resultSet.getString("hw_content"));
                        homework.sethwCreateTime(resultSet.getTimestamp("hw_create_time"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return homework;
    }

    /**
     * 向student_homework表提交作业
     * @param studentHomework 作业
     * @return true成功否则失败
     */
    public static boolean addStudentHomework(StudentHomework studentHomework){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "insert into student_homework (st_id,hw_id," +
                "hw_title,hw_content,submit_content,st_hw_create_time) values(?,?,?,?,?,?)";

        int resultSet = 0;

        try (Connection connection = DriverManager.getConnection(url, "root", "123456")) {
            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setLong(1,studentHomework.getstId());
                ps.setLong(2,studentHomework.gethwId());
                ps.setString(3,studentHomework.gethwTitle());
                ps.setString(4,studentHomework.gethwContent());
                ps.setString(5,studentHomework.getsubmitContent());
                ps.setTimestamp(6,new Timestamp(studentHomework.getsthwCreateTime().getTime()));
                resultSet = ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet > 0;
    }

}
