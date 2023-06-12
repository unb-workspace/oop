import java.util.Date;

public abstract class User {
    protected String username;
    protected String name;
    protected String password;
    protected Date creation_date;

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.creation_date = new Date();
    }

    public String getPassword() {
        return this.password;
    }

    public Date getCreationDate() {
        return this.creation_date;
    }

    public String getUsername() {
        return this.username;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "{ username: " + this.username + ", password: " + this.password + ", creation_date: " + this.creation_date + " }";
    }
}
