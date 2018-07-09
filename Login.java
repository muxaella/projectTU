import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.lang.String;
import java.sql.SQLException;
import java.sql.*;

    public class Login {
        //        public static void main(String[] args) {
//            Scanner scan = new Scanner(System.in);
//            Scanner keyboard = new Scanner(System.in);
//            String user = scan.nextLine();
//            String pass = scan.nextLine(); // looks at selected file in scan
//
//            String inpUser = keyboard.nextLine();
//            String inpPass = keyboard.nextLine(); // gets input from user
//
//            if (inpUser.equals(user) && inpPass.equals(pass)) {
//                System.out.print("your login message");
//            } else {
//                System.out.print("your error message");
//            }
//        }
//    }
//        public static void main(String[] args) {
//            Scanner input = new Scanner(System.in);
//
//            String username;
//            String password;
//
//            System.out.println("Log in:");
//            System.out.println("username: ");
//            username = input.next();
//
//            System.out.println("password: ");
//            password = input.next();
//
//            //users check = new users(username, password);
//
//            if (username.equals(username) && password.equals(password))
//                System.out.println("You are logged in");
//        }
//    }
        Connection con;
        Statement st;
        ResultSet rs;

        JFrame f = new JFrame("User login");
        JLabel l = new JLabel("User");
        JLabel l1 = new JLabel("Password");
        JTextField t = new JTextField(10);
        JTextField t1 = new JTextField(10);
        JButton b = new JButton("Button");

        public Login() {
            connect();
            frame();
        }

        public void connect() {
            try {
                String driver = "sun.jdbc.odbs.JdbsOdbcName";
                Class.forName(driver);
                String db = "jdbc:odbc:db1";
                con = DriverManager.getConnection(db);
                st = con.createStatement();

            } catch (Exception ex) {
            }
        }

        public void frame() {
            f.setSize(600, 400);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

            JPanel p = new JPanel();
            p.add(l);
            p.add(t);
            p.add(l1);
            p.add(t1);
            p.add(b);
            f.add(p);


        }


        public static void main(String[] args) {
            new Login();

        }

        public static void viewTable(Connection con, String distributor)
                throws SQLException {

            Statement stmt = null;
            String query = "select *" +

                    "from " + distributor ;
            try {
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String user = rs.getString("user");
                    Integer password = rs.getInt("password");
                    System.out.println(user + "\t" + password +
                            "\t");
                }
            } catch (SQLException e ) {

            } finally {
                if (stmt != null) { stmt.close(); }
            }
        }

    }