package command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static CommandFactory factory = new CommandFactory();

    private final Map<String, Command> commands = new HashMap<>();

    private CommandFactory() {

    }

    public static CommandFactory commandFactory() {
        if (factory==null) {
            factory = new CommandFactory();
        }
        return factory;
    }

    {
        commands.put("register", new RegisterCommand());
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("main", new MainCommand());
        commands.put("delete", new DeleteCommand());
        commands.put("search", new SearchCommand());
        commands.put("create_apartment", new CreateApartmentCommand());
        commands.put("go_to_apartment", new GoToApartmentCommand());
        commands.put("change_apartment", new ChangeApartmentCommand());
        commands.put("edit", new EditCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("action");
        return commands.get(action);
    }
}
