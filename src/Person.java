
public class Person {
    private final String firstName;
    private final String lastName;
    private final Gender gender;
    private int age;
    private Address address;
    private String fullName;

    public Person(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        fullName = gender.getPrefix()+" "+ firstName + " " + lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void changeTheFormatOfAddressingAPerson(boolean namingFormat) {
        if (namingFormat)
            fullName = gender.getPrefix()+" "+ lastName + ", " + firstName;
    }
    public String getFullName(){
        return fullName;
    }
    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Name : " + fullName +
                ", Gender : " + gender +
                ", Age : " + age +
                ", Address : \n\t" + address.toString();
    }
}
