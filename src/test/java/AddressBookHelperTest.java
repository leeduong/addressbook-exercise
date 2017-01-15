import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;

public class AddressBookHelperTest
{
    @Test
    public void maleCountShouldReturnCorrectCount() throws ParseException
    {
        int expectedMaleCount = 2;
        AddressBookHelper helper = new AddressBookHelper("AddressBookWithThreeContacts");
        assertEquals(expectedMaleCount, helper.maleCount());
    }
}
