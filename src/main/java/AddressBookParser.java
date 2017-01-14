import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
                contacts.add(new Contact());
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return contacts;
    }
}