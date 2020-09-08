package command;

import entitiy.Apartment;
import entitiy.Site;
import entitiy.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class MainCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {
        Site site = Site.getSite();
        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {
            ArrayList<Apartment> apartments = site.getApartments();
            request.setAttribute("apartments", apartments);
        }

        return "main.jsp";
    }
}
