import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws SQLException {


        Connection connection = DriverManager.getConnection("jdbc:h2:~/Numbers", "sa", "");
        Statement stmt = connection.createStatement();
//        String query = "CREATE TABLE numb("
//                + "id INT NOT NULL, "
//                + "numb VARCHAR(4) NOT NULL, "
//                + "country VARCHAR(6) NOT NULL, "
//                + "PRIMARY KEY(id))";
//        stmt.execute(query);
        NumbDao numbDao = new NumbDao(connection);
        Numb number = numbDao.getById(2);
        System.out.printf("%-5s %-10s  %-10s %n", "id", "country", "numb");
        System.out.printf("%-5d %-10s %-10s %n", number.getId(), number.getCountry(), number.getNumb());
        for (Numb number1 : numbDao.getAll()){
            if (number1.getId() == 1)
                System.out.printf("%-5s %-10s  %-10s %n", "id", "country", "numb");
            System.out.printf("%-5d %-10s %-10s %n", number1.getId(), number1.getCountry(), number1.getNumb());
        }
        connection.close();
    }
}
