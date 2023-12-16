import java.util.List;

public interface DAO {

    List<Numb> getAll();

    Numb getById(int id);

    void insertNumb(Numb numb);
}
