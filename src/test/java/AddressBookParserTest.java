import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * <p>
 * The purpose of this class is to test {@link AddressBookParser}.
 * </p>
 * 
 * @author Lee Duong
 */
public class AddressBookParserTest
{

    @Test
    public void getContactsWithEmptyContactFileShouldReturnEmptyList()
    {
        AddressBookParser addressBookParser = new AddressBookParser("AddressBookWithZeroContacts");
        assertEquals(0, addressBookParser.getContacts().size());
    }

    @Test
    public void getContactsWithOneContactFileShouldReturnOneContact()
    {
        AddressBookParser addressBookParser = new AddressBookParser("AddressBookWithOneContact");
        assertEquals(1, addressBookParser.getContacts().size());
    }

    @Test
    public void getContactsWithMultipleContactsFileShouldReturnMultipleContacts()
    {
        AddressBookParser addressBookParser = new AddressBookParser("AddressBookWithThreeContacts");
        assertEquals(3, addressBookParser.getContacts().size());
    }
}
