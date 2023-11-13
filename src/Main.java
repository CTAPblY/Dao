import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws SQLException {


        Connection connection = DriverManager.getConnection("jdbc:h2:~/DAO", "sa", "");
        //Statement stmt = connection.createStatement();
//        String query = "CREATE TABLE numb("
//                + "id INT NOT NULL, "
//                + "numb VARCHAR(4) NOT NULL, "
//                + "country VARCHAR(6) NOT NULL, "
//                + "PRIMARY KEY(id))";
//        stmt.execute(query);
        NumbDao numbDao = new NumbDao(connection);
//        numbDao.insertNumb(new Numb(1, "+61", "austr"));
//        numbDao.insertNumb(new Numb(2, "+375", "bel"));
//        numbDao.insertNumb(new Numb(3, "+44", "uk"));
//        numbDao.insertNumb(new Numb(4,	"+36",	"hun"));
//        numbDao.insertNumb(new Numb(5,	"+509",	"hai"));
//        numbDao.insertNumb(new Numb(6,	"+49", "germ"));
//        numbDao.insertNumb(new Numb(7, 	"+30", 	"greece"));
//        numbDao.insertNumb(new Numb(8,	"+45",	"den"));
//        numbDao.insertNumb(new Numb(9, 	"+972", 	"israel"));
//        numbDao.insertNumb(new Numb(10,	"+353",	"irl"));
//        numbDao.insertNumb(new Numb(11,	"+1", 	"canada"));
//        numbDao.insertNumb(new Numb(12,	"+86",	"china"));
//        numbDao.insertNumb(new Numb(13,	"+53", 	"cuba"));
//        numbDao.insertNumb(new Numb(14, 	"+52",	"mexica"));
//        numbDao.insertNumb(new Numb(15,	"+377",	"monaco"));
//        numbDao.insertNumb(new Numb(16,	"+31", 	"nether"));
//        numbDao.insertNumb(new Numb(17, 	"+47",	"norw"));
//        numbDao.insertNumb(new Numb(18,	"+351",	"port"));
//        numbDao.insertNumb(new Numb(19,	"+90", 	"turk"));
//        numbDao.insertNumb(new Numb(20,	"+358",	"finl"));
//        for (Numb i : numbDao.getAll()){
//            if (i.getId() == 1)
//                System.out.printf("%-5s %-10s  %-10s %n", "id", "country", "numb");
//            System.out.printf("%-5d %-10s %-10s %n", i.getId(), i.getCountry(), i.getNumb());
//        }
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
