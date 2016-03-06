import java.util.HashMap;
import java.util.LinkedList;

public class GuestManager {
    private final String[] personsDetail;
    private final String formatOption;
    LinkedList<Guest> guests = new LinkedList<>();
    HashMap<String, NameFormatter> nameFormatter = new HashMap<>();

    public GuestManager(String formatoption, String[] personsDetail) {
        this.personsDetail = personsDetail;
        this.formatOption = formatoption;
        nameFormatter.put("--FORMAL", new FormalName());
        nameFormatter.put("--INFORMAL", new InformalName());
    }

    public void generateGuestList() {

        for (String details : personsDetail) {
            String[] detail = details.split(",");
            Name name = new Name(detail[0], detail[1]);
            name.addNameFormatter(nameFormatter.get(formatOption.toUpperCase()));
            Gender gender = new Gender(detail[2]);
            int age = Integer.parseInt(detail[3]);
            String city = detail[4];
            String state = detail[5];
            String country = detail[6];
            Address address = new Address(city, state, country);
            Guest guest = new Guest(name, gender, age, address);
            guests.add(guest);
        }
    }

    public LinkedList<String> generateLevel() {
        LinkedList<String> templates = new LinkedList<>();
        for (Guest guest : guests)
            templates.add(guest.generateLevel());
        return templates;
    }
    public LinkedList<String> generateLevel(String country) {
        LinkedList<String> templates = new LinkedList<>();
        for (Guest guest : guests)
            if(guest.isResidentOf(country))
                templates.add(guest.generateLevel());
        return templates;
    }
}
