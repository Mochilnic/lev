package entitiy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Apartment {

    private String header;
    private String cost;
    private String description;
    private Set<Parameter> parameters = new HashSet<>();
    private User creator;

    public void addParameter(Parameter parameter) {
        parameters.add(parameter);
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(Set<Parameter> parameters) {
        this.parameters = parameters;
    }
}
