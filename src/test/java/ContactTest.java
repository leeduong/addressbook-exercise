import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * The purpose of this class is to test {@link Contact}.
 * </p>
 * 
 * @author Lee Duong
 */
public class ContactTest
{
    private String validName;
    private Date validDateOfBirth;
    private Gender validGender;
    Contact contact;
    
    @Before
    public void setUp()
    {
        validName = "Test Name";
        validDateOfBirth = Calendar.getInstance().getTime();
        validGender = Gender.FEMALE;
        contact = new Contact.Builder().name(validName).gender(validGender).dateOfBirth(validDateOfBirth).build();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setNameWithNullValueShouldThrowException()
    {
        new Contact.Builder().name(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setNameWithEmptyStringShouldThrowException()
    {
        new Contact.Builder().name("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setDateOfBirthWithNullValueShouldThrowException()
    {
        new Contact.Builder().dateOfBirth(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setGenderWithNullValueShouldThrowException()
    {
        new Contact.Builder().gender(null);
    }
    
    @Test
    public void getNameWithValidValueShouldReturnCorrectName()
    {
        assertEquals(validName, contact.getName());
    }
    
    @Test
    public void getDateOfBirthWithValidValueShouldReturnCorrectDateOfBirth()
    {
        assertEquals(validDateOfBirth, contact.getDateOfBirth());
    }
    
    @Test
    public void getGenderWithValidValueShouldReturnCorrectGender()
    {
        assertEquals(validGender, contact.getGender());
    }
}