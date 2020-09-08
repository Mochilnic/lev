package command;

import entitiy.Apartment;
import entitiy.Site;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GoToApartmentCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {
        Site site = Site.getSite();

        ArrayList<Apartment> apartments = site.getApartments();

        ArrayList<String> headers = apartments.stream()
                .map(Apartment::getHeader)
                .collect(Collectors.toCollection(ArrayList::new));

        int index = headers.indexOf(request.getParameter("apartment"));

        Apartment apartment = apartments.get(index);

        request.setAttribute("apartment", apartment);

        return "go_to_apartment.jsp";
    }
}
