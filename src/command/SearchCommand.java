package command;

import entitiy.Apartment;
import entitiy.Parameter;
import entitiy.Site;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String search = request.getParameter("search");

        String[] split = search.split(", ");
        Set<String> searchParameters = new HashSet<>(Arrays.asList(split));

        Site site = Site.getSite();
        ArrayList<Apartment> apartments = site.getApartments();

        ArrayList<Apartment> completeApartments = new ArrayList<>();

        for (Apartment apartment : apartments) {
            Set<Parameter> parameters = apartment.getParameters();
            HashSet<String> collect = parameters.stream()
                    .map(Parameter::getParameter)
                    .collect(Collectors.toCollection(HashSet::new));
            if (collect.containsAll(searchParameters)) {
                completeApartments.add(apartment);
            }
        }

        request.setAttribute("searchApartments", completeApartments);

        return "search.jsp";
    }
}
