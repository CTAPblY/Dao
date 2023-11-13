import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NumbDao  {

    private Connection connection;

    public NumbDao(){}

    public NumbDao(Connection connection){
        this.connection = connection;
    }

    public List<Numb> getAll(){

        try {
            List<Numb> numb = new ArrayList<Numb>();

            PreparedStatement ps = this.connection.prepareStatement("select * from numb");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Numb numb1 = new Numb();
                numb1.setId(rs.getInt("id"));
                numb1.setNumb(rs.getString("numb"));
                numb1.setCountry(rs.getString("country"));
                numb.add(numb1);
            }

            ps.close();

            return numb;

        }   catch (SQLException e){
                throw new RuntimeException(e);
        }

    }

    public Numb getById(int id){
        try {
            Numb numb = new Numb();

            PreparedStatement ps = this.connection.prepareStatement("select * from numb where id = " + id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(id == rs.getInt("id")) {
                    numb.setId(rs.getInt("id"));
                    numb.setNumb(rs.getString("numb"));
                    numb.setCountry(rs.getString("country"));
                }
            }

            ps.close();

            return numb;

        }   catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    public void insertNumb(Numb numb) {

        try {
            PreparedStatement ps = this.connection.prepareStatement("insert into numb(id, numb, country)  values(?, ?, ?)");
            ps.setInt(1, numb.getId());
            ps.setString(2, numb.getNumb());
            ps.setString(3, numb.getCountry());

            ps.execute();
            ps.close();
        }   catch(SQLException e){

            throw new RuntimeException(e);

        }
    }

}
