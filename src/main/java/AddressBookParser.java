import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * The purpose of this class is to process the address book file and return a list of contacts.
 * </p>
 * 
 * @author Lee Duong
 */
public class AddressBookParser
{

    private String fileName;

    /**
     * The Address book constructor.
     * 
     * @param fileName
     *            The file name to process.
     */
    public AddressBookParser(String fileName)
    {
        this.fileName = fileName;
    }

    /**
     * Retrieves a list of contacts from the address book file.
     *
     * @return a list of contacts.
     */
    public List<Contact> getContacts()
    {
        List<Contact> contacts = new ArrayList<Contact>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        try
        {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] contactProperties = line.split(", ");
                String name = contactProperties[0];

                String genderName = contactProperties[1].toUpperCase();
                Gender gender = Gender.valueOf(genderName);
                
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
                Date dateOfBirth = null;
                try
                {
                    dateOfBirth = simpleDateFormat.parse(contactProperties[2]);
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }
                
                contacts.add(new Contact.Builder().name(name).gender(gender).dateOfBirth(dateOfBirth).build());
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return contacts;
    }
}