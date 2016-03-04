
public class Gender {
    private final String gender;
    public Gender(String gender) {
        this.gender = gender;
    }
    public String getPrefix(){
        if(gender.toUpperCase().equals("MALE"))
            return "Mr";
        if(gender.toUpperCase().equals("FEMALE"))
            return  "Ms";
        return "";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Gender)) return false;
        Gender gender1 = (Gender) other;
        return gender != null ? gender.equals(gender1.gender) : gender1.gender == null;
    }

}
