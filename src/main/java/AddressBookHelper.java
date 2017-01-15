import java.util.List;

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


    public int maleCount()
    {
        int count = 0;
        for (Contact contact : contacts)
        {
            if (Gender.MALE.equals(contact.getGender()))
            {
                count++;
            }
        }
        return count;
    }
}
