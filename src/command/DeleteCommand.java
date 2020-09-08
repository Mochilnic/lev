package command;

import entitiy.Apartment;
import entitiy.Site;
import entitiy.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DeleteCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {
        String header = request.getParameter("apartment");

        Site site = Site.getSite();

        ArrayList<Apartment> siteApartments = site.getApartments();

        ArrayList<String> headers = siteApartments.stream()
                .map(Apartment::getHeader)
                .collect(Collectors.toCollection(ArrayList::new));

        int index = headers.indexOf(header);

        Apartment apartment = siteApartments.get(index);

        User user = apartment.getCreator();

        site.removeApartment(apartment);
        user.removeApartment(apartment);

        return "controller?action=main";
    }
}
