package command;

import entitiy.Apartment;
import entitiy.Parameter;
import entitiy.Site;
import entitiy.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EditCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {
        Site site = Site.getSite();
        User user = (User) request.getSession().getAttribute("user");

        String newHeader = request.getParameter("header");
        String newDescription = request.getParameter("apartment");
        String oldHeader = request.getParameter("oldHeader");
        String newCost = request.getParameter("cost");
        String parameters = request.getParameter("parameters");

        String[] split = parameters.split(", ");
        Set<Parameter> parameterSet = new HashSet<>();

        ArrayList<Apartment> siteApartments = site.getApartments();
        ArrayList<Apartment> userApartments = user.getApartments();

        ArrayList<String> sitePostsHeaders = siteApartments.stream()
                .map(Apartment::getHeader)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<String> userPostsHeaders = userApartments.stream()
                .map(Apartment::getHeader)
                .collect(Collectors.toCollection(ArrayList::new));

        int indexUser = userPostsHeaders.indexOf(oldHeader);
        int indexSite = sitePostsHeaders.indexOf(oldHeader);

        Apartment apartment = userApartments.get(indexUser);

        apartment.setHeader(newHeader);
        apartment.setDescription(newDescription);
        apartment.setCost(newCost);

        for (String s : split) {
            Parameter parameter = new Parameter();
            parameter.setParameter(s);
            parameterSet.add(parameter);
        }

        apartment.setParameters(parameterSet);

        siteApartments.set(indexSite, apartment);
        userApartments.set(indexUser, apartment);

        request.setAttribute("apartment", apartment);

        return "go_to_apartment.jsp";
    }
}
