package com.java.code.Jdbc;

import com.java.code.Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJdbc {

    public static void main(String[] args) {

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

    public static List<Meeting> showMeeting(){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "SELECT * FROM meeting";

        List<Meeting> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, "root", "123456")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        Meeting meeting = new Meeting();
                        meeting.setId(resultSet.getInt("id"));
                        meeting.setTitle(resultSet.getString("title"));
                        meeting.setContent(resultSet.getString("content"));
                        meeting.setAddress(resultSet.getString("address"));
                        meeting.setSender(resultSet.getString("sender"));
                        meeting.setStarttime(resultSet.getString("starttime"));
                        meeting.setEndtime(resultSet.getString("endtime"));
                        list.add(meeting);
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

    public static void updateToMeeting(Meeting meeting) {
        Connection con = null;
        PreparedStatement pstm = null;
        String url = "jdbc:mysql://localhost:3306/school?serverTimezone=UTC";
        String user = "root";
        String pwd = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pwd);

            String sql = "update meeting set title=?,content=?,address=?,sender=?,starttime=?,endtime=? where id= ?" ;
            pstm = con.prepareStatement(sql);
            pstm.setString(1,meeting.getTitle());
            pstm.setString(2,meeting.getContent());
            pstm.setString(3,meeting.getAddress());
            pstm.setString(4,meeting.getSender());
            pstm.setString(5,meeting.getStarttime());
            pstm.setString(6,meeting.getEndtime());
            pstm.setInt(7,meeting.getId());

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
            Class.forName("com.mysql.cj.jdbc.Driver");

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

    public static void DeleteMeeting(int id) {
        Connection con=null;
        PreparedStatement pstmt=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url="jdbc:mysql://localhost:3306/school?serverTimezone=UTC";
            String user="root";
            String password="123456";
            con=DriverManager.getConnection(url, user, password);

            String sql="delete from meeting where id=?";
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



}
