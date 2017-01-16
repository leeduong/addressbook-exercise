import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
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
    private static final int NAME_INDEX = 0;
    private static final int GENDER_INDEX = 1;
    private static final int DOB_INDEX = 2;
    
    /**
     * The Address book constructor.
     * 
     * @param fileName
     *            The file name to process.
     * @throws IllegalArgumentException
     *             if {@code fileName} is {@code null} or empty.
     */
    public AddressBookParser(String fileName)
    {
        if (fileName == null || fileName.isEmpty())
        {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }
        this.fileName = fileName;
    }

    /**
     * Retrieves a list of contacts from the address book file.
     *
     * @return a list of contacts. Returns an empty list of contacts if the file cannot be found.
     */
    public List<Contact> getContacts()
    {
        List<Contact> contacts = new ArrayList<Contact>();
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        if (url != null)
        {
            File file = new File(url.getFile());
            try
            {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine())
                {
                    String line = scanner.nextLine();
                    String[] contactProperties = line.split("[ ]*,[ ]*");
                    String name = contactProperties[NAME_INDEX];

                    String genderName = contactProperties[GENDER_INDEX].toUpperCase();
                    Gender gender = Gender.valueOf(genderName);

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
                    Date dateOfBirth = null;
                    try
                    {
                        dateOfBirth = simpleDateFormat.parse(contactProperties[DOB_INDEX]);
                    }
                    catch (ParseException e)
                    {
                        e.printStackTrace();
                    }

                    contacts.add(new Contact.Builder().name(name).gender(gender).dateOfBirth(dateOfBirth).build());
                }
                scanner.close();
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        return contacts;
    }
}