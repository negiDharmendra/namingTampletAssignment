import java.util.LinkedList;

public class GuestManager {
    private final String[] personsDetail;
    private final NameFormatter nameFormatter;
    LinkedList<Guest> guests = new LinkedList<>();

    public GuestManager(NameFormatter nameFormatter, String[] personsDetail) {
        this.personsDetail = personsDetail;
        this.nameFormatter = nameFormatter;
    }

    public void generateGuestList() {

        for (String details : personsDetail) {
            String[] detail = details.split(",");
            Name name = new Name(detail[0], detail[1]);
            name.addNameFormatter(nameFormatter);
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

    private String filterOutGuest(Filter filter, Guest guest) {
       String filterResult =  filter.filter(guest);
        if (filterResult!=null)
            return filterResult;
        return null;
    }

    public LinkedList<String> generateLevel() {
        LinkedList<String> templates = new LinkedList<>();
        for (Guest guest : guests)
            templates.add(guest.generateLevel());
        return templates;
    }

    public LinkedList<String> generateLevel(LinkedList<Filter> filters) {
        LinkedList<String> templates = new LinkedList<>();
        for (Guest guest : guests) {
            String optionalLabels = "";
            boolean prevFilterResult = true;
            for (Filter filter : filters) {
                String filterResult = filterOutGuest(filter, guest);
                if (filterResult != null&&prevFilterResult) {
                    prevFilterResult = true;
                    optionalLabels +=(", "+filterResult);
                }
                else prevFilterResult=false;
            }
            if(prevFilterResult)templates.add(guest.generateLevel()+optionalLabels);
        }
        return templates;
    }
}
