import static org.junit.Assert.assertEquals;

import java.text.ParseException;

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
}
