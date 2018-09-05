package com.oak.model.util;


import java.sql.*;

public class JdbcUtils {

    private static final String URL = "jdbc:mysql://192.168.26.198:3306/wty";

    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "root";

    public JdbcUtils(){}

    static{
        try{
            Class.forName(DRIVER);
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try{
            Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            return con;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection , PreparedStatement pdst , ResultSet result){

        try{
            if(connection != null){
                connection.close();
            }
            try{
                if(pdst != null){
                    pdst.close();
                }
                try{
                    if(result != null){
                        result.close();
                    }
                }catch(Exception ex){

                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

}
