public class Main {
    public static void main(String[] args) {

        Address aptAddress = new Address("teineTänav", 14, 124414, 2, true, 34);

        Person person1 = new Person("Meelis Mega", 24, new Address("Tänav", 15, 31314, 3, false, 0));
        Person person2 = new Person("Mari Magab", 23, aptAddress);

        System.out.println(person1.address);
        person1.changeAge(2);

        System.out.println(person1.address.aptNumber);
        System.out.println(person2.address.aptNumber);

        person1.address.changeAptNumber(3);
        person2.address.changeAptNumber(132);

        System.out.println(person1.address.aptNumber);
        System.out.println(person2.address.aptNumber);
    } // Main args
} // Main end