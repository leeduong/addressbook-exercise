import static org.junit.Assert.assertEquals;

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
}
