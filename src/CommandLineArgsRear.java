import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class CommandLineArgsRear {
    private final String[] args;
    public CommandLineArgsRear(String [] args) {
        this.args = args;
    }

    public NameFormatter getNameFormatter() {
        HashMap<String,NameFormatter>  nameFormatters = new HashMap<>();
        nameFormatters.put("--formal",new FormalName());
        nameFormatters.put("--informal",new InformalName());
        return nameFormatters.get(args[0]);
    }

    public LinkedList<Filter> getFilters() {
        LinkedList<Filter> filters =  new LinkedList<>();
        Pattern pattern =  Pattern.compile("--filter");
        for (String arg :args) {
            if(pattern.matcher(arg).find())
               addFilter(arg,filters);
        }
        return filters;
    }

    private void addFilter(String arg,LinkedList<Filter> filters) {
        HashMap<String, Filter> allFilters = new HashMap<>();
        allFilters.put("--filterCountry",new CountryFilter());
        allFilters.put("--filterAge",new AgeFilter());
        String [] filterOption = arg.split("_");
        Filter filter = allFilters.get(filterOption[0]);
        filter.addConstrain(filterOption[1]);
        filters.add(filter);
    }

    public LinkedList<String> getFilesName() {
        LinkedList<String> files = new LinkedList<>();
        for (String arg :args)
            if(!arg.substring(0,2).equals("--"))
                files.add(arg);
        return files;
    }
}
