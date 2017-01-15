import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * <p>
 * The purpose of this class is to test {@link AddressBookHelper}.
 * </p>
 * 
 * @author Lee Duong
 */
public class AddressBookHelperTest
{
    @Test
    public void maleCountShouldReturnCorrectCount() throws ParseException
    {
        int expectedMaleCount = 2;
        AddressBookHelper helper = new AddressBookHelper("AddressBookWithThreeContacts");
        assertEquals(expectedMaleCount, helper.genderCount(Gender.MALE));
    }
    
    @Test
    public void femaleCountShouldReturnCorrectCount() throws ParseException
    {
        int expectedFemaleCount = 1;
        AddressBookHelper helper = new AddressBookHelper("AddressBookWithThreeContacts");
        assertEquals(expectedFemaleCount, helper.genderCount(Gender.FEMALE));
    }
    
    @Test
    public void maleAndFemaleCountShouldReturnCorrectCount() throws ParseException
    {
        int expectedCount = 3;
        AddressBookHelper helper = new AddressBookHelper("AddressBookWithThreeContacts");
        assertEquals(expectedCount, helper.genderCount(null));
    }
    
    @Test
    public void getOldestShouldReturnOldestContact() throws ParseException
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        Date expectedDate = simpleDateFormat.parse("16/03/61");
        String expectedName = "John Smith";
        Gender expectedGender = Gender.MALE;
        AddressBookHelper helper = new AddressBookHelper("AddressBookWithDateOfBirthNotInOrder");
        Contact oldestContact = helper.getOldest();
        assertEquals(expectedName, oldestContact.getName());
        assertEquals(expectedGender, oldestContact.getGender());
        assertEquals(expectedDate, oldestContact.getDateOfBirth());
    }
    
    @Test
    public void getContactWithValidNameShouldReturnContactWithMatchingName() throws ParseException
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        Date expectedDate = simpleDateFormat.parse("15/01/85");
        String expectedName = "Paul Robinson";
        Gender expectedGender = Gender.MALE;
        AddressBookHelper helper = new AddressBookHelper("AddressBookWithThreeContacts");
        Contact contact = helper.getContact("Paul Robinson");
        assertEquals(expectedName, contact.getName());
        assertEquals(expectedGender, contact.getGender());
        assertEquals(expectedDate, contact.getDateOfBirth());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void getContactWithNullNameShouldThrowException()
    {
        AddressBookHelper helper = new AddressBookHelper("AddressBookWithThreeContacts");
        helper.getContact(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void getContactWithBlankNameShouldThrowException()
    {
        AddressBookHelper helper = new AddressBookHelper("AddressBookWithThreeContacts");
        helper.getContact("");
    }
    
    @Test
    public void getContactWithNameThatDoesMatchShouldReturnNull()
    {
        AddressBookHelper helper = new AddressBookHelper("AddressBookWithThreeContacts");
        assertNull(helper.getContact("Name that does not match a name from AddressBookWithThreeContacts"));  
    }
    
    @Test
    public void daysBetweenDatesOfBirthShouldReturnCorrectDays()
    {
        long expectedDays = 2862L;
        AddressBookHelper helper = new AddressBookHelper("AddressBookWithThreeContacts");
        assertEquals(expectedDays,helper.daysBetweenDatesOfBirth(helper.getContact("Bill McKnight"), helper.getContact("Paul Robinson")));
    }
}