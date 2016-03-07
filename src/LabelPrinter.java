import java.io.IOException;
import java.util.LinkedList;

public class LabelPrinter {
    private static String usage = "USAGE:\n\t" +
            "./informalLebePrinter.sh [--help]\n\t" +
            "./formalLebePrinter.sh [--help]\n\t" +
            "formalLebePrinter.sh  fileName  --[countryname]\n\t" +
            "informalLebePrinter.sh  fileName  --[countryname]";

    public static void main(String[] args) throws IOException {
        if (args.length > 4 || args.length == 1 || args[1].equals("--help")) System.out.println(usage);
        else{
            CommandLineArgsRear commandLineArgsRear = new CommandLineArgsRear(args);
            LinkedList<Filter> filters = commandLineArgsRear.getFilters();
            NameFormatter nameFormatter = commandLineArgsRear.getNameFormatter();
            LinkedList<String> filesName = commandLineArgsRear.getFilesName();
            createTemplate(nameFormatter,filesName.get(0),filters);
        }


    }

    private static void createTemplate(NameFormatter option, String guestList, LinkedList<Filter> filters) throws IOException {
        ReadGuestList readGuestList = new ReadGuestList(guestList);
        GuestManager guestManager = new GuestManager(option, readGuestList.read());
        guestManager.generateGuestList();
        LinkedList<String> tepmlates;
        if(filters.size()>0) tepmlates = guestManager.generateLevel(filters);
        else tepmlates = guestManager.generateLevel();
        for (String tepmlate : tepmlates) {
            System.out.println(tepmlate);
        }
    }


}
