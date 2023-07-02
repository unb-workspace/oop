package models;

/**
 * A classe Address contém informações a respeito do endereço físico de uma empresa.
 * @author Ana Clara, Arthur e Caio.
 * @since 2023.
 * @version 1.2
 */
public class Address {
    private String state;
    private String city;
    private String street;

    /**
     * Método construtor responsável por definir um endereço físico.
     * @param state determina o estado no qual a empresa está localizada
     * @param city determina a cidade na qual a empresa está lozalizada
     * @param street determina a rua na qual a empresa está localizada
     */
    public Address(String state, String city, String street) {
        this.state = state;
        this.city = city;
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String toString(){
        return "{ State: " + getState() + ", City: " + getCity() + ", Street: " + getStreet() + " }";
    }
}