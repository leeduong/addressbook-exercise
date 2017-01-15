import java.util.Comparator;
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
     * Retrieves the first contact from the address book matching the name specified.
     * 
     * @param name
     *            The name of the contact to retrieve.
     *
     * @return the first contact from the address book matching the name specified. If there is no matching contact then
     *         {@code null} is returned.
     * 
     * @throws IllegalArgumentException
     *             if {@code name} is {@code null} or empty.
     */
    public Contact getContact(String name)
    {
        if (name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        for (Contact contact : contacts)
        {
            if (contact.getName().toUpperCase().equals(name.toUpperCase()))
            {
                return contact;
            }
        }
        return null;
    }

    /**
     * Retrieves the oldest contact.
     *
     * @return the oldest contact.
     */
    public Contact getOldest()
    {
        contacts.sort((contactOne, contactTwo) -> contactOne.getDateOfBirth().compareTo(contactTwo.getDateOfBirth()));
        return contacts.get(0);
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
