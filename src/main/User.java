import java.util.Date;

public class User {
    private String username;
    private String password;
    private Date creation_date;
    private int company_id;

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

}
