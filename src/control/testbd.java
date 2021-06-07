package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testbd {
    private static  final String URL="jdbc:mariadb://localhost:3306/empresa";
    private static  final String USER="root";
    private static  final String PASSWORD="";

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("COnectado");
    }
}
