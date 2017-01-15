import java.util.List;
import java.util.function.Predicate;

/**
 * <p>
 * The purpose of this class is to read the address book file and provide useful methods such as the count of males in
 * the address book.
 * </p>
 * 
 * @author Lee Duong
 */
public class AddressBookHelper
{
    private List<Contact> contacts;

    /**
     * The Address book helper constructor.
     * 
     * @param fileName
     *            The file name to process.
     */
    public AddressBookHelper(String fileName)
    {
        contacts = new AddressBookParser(fileName).getContacts();
    }

    /**
     * Retrieves a count for the gender specified.
     * 
     * @param gender
     *            The gender to count.
     *
     * @return a count for the gender specified. If a {@code null} gender is specified then a count of both male and
     *         female is returned.
     */
    public int genderCount(Gender gender)
    {
        if (gender == null)
        {
            return count(contact -> true);
        }
        return count(contact -> gender.equals(contact.getGender()));
    }

    private int count(Predicate<Contact> predicate)
    {
        int count = 0;
        for (Contact contact : contacts)
        {
            if (predicate.test(contact))
            {
                count++;
            }
        }
        return count;
    }
}
