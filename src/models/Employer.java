public class Employer extends User {
    private Company company;
    private String role;

    public Employer(String username, String password, String name) {
        super(username, password, name);

        this.role = "No role";
    }

    public Company getCompany() {
        return company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String toString() {
        return "{ username: " + this.username + ", password: " + this.password + ", name: " + this.name + ", role: " + this.role + ", company: " + this.company + " }";
    }

}
