import java.util.HashMap;

public class Gender {
    private final String gender;
    HashMap<String,String> honorifics = new HashMap<>();
    public Gender(String gender) {
        this.gender = gender;
        this.honorifics.put("MALE","Mr");
        this.honorifics.put("FEMALE","Ms");

    }
    public String createHonorific(){
        return ""+honorifics.get(gender.toUpperCase());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Gender)) return false;
        Gender gender1 = (Gender) other;
        return gender != null ? gender.equals(gender1.gender) : gender1.gender == null;
    }

}
