public class Company {
    private final int ID;
    private String name;
    private final String occupation_area;
    private String email;
    private long cellphone_number;
    private final User owner;

    public Company(int ID, User owner, String name, String occupation_area, String email, long cellphone_number) {
        this.ID = ID;
        this.owner = owner;
        this.name = name;
        this.occupation_area = occupation_area;
        this.email = email;
        this.cellphone_number = cellphone_number;
    }
    public int getId() {
        return ID;
    }

    public User getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String getOccupationArea() {
        return occupation_area;
    }

    public String getEmail() {
        return email;
    }

    public long getCellphoneNumber() {
        return cellphone_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCellphoneNumber(long cellphone_number) {
        this.cellphone_number = cellphone_number;
    }
}
