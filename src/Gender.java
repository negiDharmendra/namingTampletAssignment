/**
 * Created by dharmenn on 04/03/16.
 */
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
}
