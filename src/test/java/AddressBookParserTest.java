import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public void constructorWithNullFileNameShouldThrowException()
    {
    }
    
    @Test
    public void constructorWithInvalidFileNameShouldThrowException()
    {
    }
    
    @Test
    public void getContactsWithEmptyContactFileShouldReturnEmptyList()
    {
        AddressBookParser addressBookParser = new AddressBookParser("AddressBookWithZeroContacts");
        assertEquals(0, addressBookParser.getContacts().size());
    }

    @Test
    public void getContactsWithOneContactFileShouldReturnOneContact() throws ParseException
    {
        AddressBookParser addressBookParser = new AddressBookParser("AddressBookWithOneContact");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        Date expectedDate = simpleDateFormat.parse("16/03/77");
        String expectedName = "Bill McKnight";
        Gender expectedGender = Gender.MALE;
        assertEquals(1, addressBookParser.getContacts().size());
        Contact contact = addressBookParser.getContacts().get(0);
        assertEquals(expectedName, contact.getName());
        assertEquals(expectedGender, contact.getGender());
        assertEquals(expectedDate, contact.getDateOfBirth());
    }

    @Test
    public void getContactsWithMultipleContactsFileShouldReturnMultipleContacts() throws ParseException
    {
        AddressBookParser addressBookParser = new AddressBookParser("AddressBookWithThreeContacts");
        assertEquals(3, addressBookParser.getContacts().size());
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        Date expectedDateOne = simpleDateFormat.parse("16/03/77");
        String expectedNameOne = "Bill McKnight";
        Gender expectedGenderOne = Gender.MALE;
        Date expectedDateTwo = simpleDateFormat.parse("15/01/85");
        String expectedNameTwo = "Paul Robinson";
        Gender expectedGenderTwo = Gender.MALE;
        Date expectedDateThree = simpleDateFormat.parse("20/11/91");
        String expectedNameThree = "Gemma Lane";
        Gender expectedGenderThree = Gender.FEMALE;
        
        Contact contactOne = addressBookParser.getContacts().get(0);
        assertEquals(expectedNameOne, contactOne.getName());
        assertEquals(expectedGenderOne, contactOne.getGender());
        assertEquals(expectedDateOne, contactOne.getDateOfBirth());        
        Contact contactTwo = addressBookParser.getContacts().get(1);
        assertEquals(expectedNameTwo, contactTwo.getName());
        assertEquals(expectedGenderTwo, contactTwo.getGender());
        assertEquals(expectedDateTwo, contactTwo.getDateOfBirth());
        Contact contactThree = addressBookParser.getContacts().get(2);
        assertEquals(expectedNameThree, contactThree.getName());
        assertEquals(expectedGenderThree, contactThree.getGender());
        assertEquals(expectedDateThree, contactThree.getDateOfBirth());
    }
}