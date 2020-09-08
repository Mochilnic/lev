package entitiy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Site {

    private static Site site = new Site();
    private Map<String, User> users = new HashMap<>();
    private ArrayList<Apartment> apartments = new ArrayList<>();

    private Site() {

    }

    public static Site getSite() {
        if (site ==null) {
            site = new Site();
        }
        return site;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }

    public void removeApartment(Apartment apartment) {
        apartments.remove(apartment);
    }

    public ArrayList<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(ArrayList<Apartment> apartments) {
        this.apartments = apartments;
    }
}
