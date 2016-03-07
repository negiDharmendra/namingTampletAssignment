public class AgeFilter implements Filter {
    private  int age;
    public AgeFilter() {
    }
    public void addConstrain(Object age){
       this.age = Integer.parseInt(age+"");
    };
    @Override
    public String filter(Guest guest) {
        if(guest.isAgeAbove(age))
             return guest.getAge();
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgeFilter ageFilter = (AgeFilter) o;

        return age == ageFilter.age;

    }

    @Override
    public int hashCode() {
        return age;
    }
}
