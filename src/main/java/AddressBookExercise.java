/**
 * <p>
 * The purpose of this class is to answer questions on the address book file.
 * </p>
 * 
 * @author Lee Duong
 */
public class AddressBookExercise
{
    public static void main(String[] args)
    {
        AddressBookHelper helper = new AddressBookHelper("AddressBook");
        System.out.println("How many male are in the address book?");
        System.out.println(helper.genderCount(Gender.MALE));
        System.out.println("Who is the oldest person in the address book?");
        System.out.println(helper.getOldest().getName());
        System.out.println("How many days older is Bill than Paul?");
        System.out.println(helper.daysBetweenDatesOfBirth(helper.getContact("Bill McKnight"), helper.getContact("Paul Robinson")));
    }
}