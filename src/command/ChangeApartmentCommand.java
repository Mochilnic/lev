package command;

import entitiy.Apartment;
import entitiy.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ChangeApartmentCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");

        ArrayList<Apartment> apartments = user.getApartments();
        String headerForParsing = request.getParameter("apartment");

        ArrayList<String> headers = apartments.stream()
                .map(Apartment::getHeader)
                .collect(Collectors.toCollection(ArrayList::new));

        int index = headers.indexOf(headerForParsing);

        Apartment apartment = apartments.get(index);

        request.setAttribute("toChange", apartment);

        return "change_apartment.jsp";
    }
}
