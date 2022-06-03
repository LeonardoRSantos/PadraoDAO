package org.wyden.pdao.connection;


import java.sql.*;


/*É um recipiente que podem conter vários objetos. São utilizados para gerir e organizar os objetos do banco de dados.

 */
public class MySQLConnector {

    private static Connection con = null;

    private ResultSet rs;
    private Statement st;

    static
    {
        String URL = "jdbc:mysql://localhost:3306/pessoasdb";
        String USER = "root";
        String PASSWORD = "itaChi*19951985";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection(){
        return con;
    }

    public ResultSet query(String sql) {
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }



}
