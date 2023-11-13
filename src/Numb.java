public class Numb {

    private int id;
    private String numb;
    private String country;

    public Numb(){}

    public Numb(int id, String numb, String country) {
        this.id = id;
        this.numb = numb;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumb() {
        return numb;
    }

    public void setNumb(String numb) {
        this.numb = numb;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
