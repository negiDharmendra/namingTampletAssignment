import java.io.IOException;
import java.util.LinkedList;

public class LabelPrinter {
    private static String usage = "USAGE:\n\t" +
            "./informalLebePrinter.sh [--help]\n\t" +
            "./formalLebePrinter.sh [--help]\n\t" +
            "formalLebePrinter.sh  fileName  --[countryname]\n\t" +
            "informalLebePrinter.sh  fileName  --[countryname]";

    public static void main(String[] args) throws IOException {
        if (args.length > 3 || args.length == 1 || args[1].equals("--help")) System.out.println(usage);
        if (!args[1].equals("--help") && args.length > 1) createTemplate(args[0], args[1]);

    }

    private static void createTemplate(String option, String guestList) throws IOException {
        ReadGuestList readGuestList = new ReadGuestList(guestList);
        GuestManager guestManager = new GuestManager(option, readGuestList.read());
        guestManager.generateGuestList();
        LinkedList<String> tepmlates = guestManager.generateLevel();
        for (String tepmlate : tepmlates) {
            System.out.println(tepmlate);
        }
    }


}
