public class Company {
    private final int ID;
    private String name;
    private final String occupation_area;
    private String email;
    private final User owner;

    private Address address;

    public Company(int ID, User owner, String name, String occupation_area, String email) {
        this.ID = ID;
        this.owner = owner;
        this.name = name;
        this.occupation_area = occupation_area;
        this.email = email;
    }

    public Company(int ID, User owner, String name, String occupation_area, String email, Address address) {
        this.ID = ID;
        this.owner = owner;
        this.name = name;
        this.occupation_area = occupation_area;
        this.email = email;
        this.address = address;
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
    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String toString() {
        return "{ name: " + getName() + ", email: " + getEmail() + ", occupation_area: " + getOccupationArea() + ", id: " + getId() + ", owner: " + owner.getUsername() + " }";
    }
}