import java.util.Date;

public class User {
    private final String username;
    private final String password;
    private Date creation_date;
    private int company_id;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.creation_date = new Date();
    }

    public User(String username, String password, int company_id) {
        this.username = username;
        this.password = password;
        this.creation_date = new Date();
        this.company_id = company_id;
    }

    public void setCompany(int id) {
        company_id = id;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreationDate() {
        return creation_date;
    }

    public int getCompany() {
        return company_id;
    }

    public String getUsername() {
        return username;
    }

    public String toString() {
        return "{ name: " + username + ", password: " + password + ", creation_date: " + creation_date + ", company_id: " + company_id + " }";
    }
}
