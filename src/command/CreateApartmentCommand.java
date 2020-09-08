package command;

import entitiy.Apartment;
import entitiy.Parameter;
import entitiy.Site;
import entitiy.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CreateApartmentCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        Site site = Site.getSite();
        User user = (User) request.getSession().getAttribute("user");

        String header = request.getParameter("header");
        String description = request.getParameter("apartment");
        String parameters = request.getParameter("parameters");
        String cost = request.getParameter("cost");

        String[] split = parameters.split(", ");
        Set<Parameter> parameterSet = new HashSet<>();

        Apartment apartment = new Apartment();

        apartment.setHeader(header);
        apartment.setDescription(description);
        apartment.setCost(cost);

        for (String s : split) {
            Parameter parameter = new Parameter();
            parameter.setParameter(s);
            parameterSet.add(parameter);
        }

        apartment.setParameters(parameterSet);
        apartment.setCreator(user);

        user.addApartment(apartment);
        site.addApartment(apartment);

        return "controller?action=main";
    }
}
