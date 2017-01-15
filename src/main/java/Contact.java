import java.util.Date;

/**
 * <p>
 * A class to hold contact information.
 * </p>
 * 
 * @author Lee Duong
 */
public class Contact
{
    private String name;
    private Date dateOfBirth;
    private Gender gender;

    private Contact(Builder builder)
    {
        this.name = builder.name;
        this.dateOfBirth = builder.dateOfBirth;
        this.gender = builder.gender;
    }

    /**
     * @return the name of the contact. Guaranteed to not be {@code null} or empty.
     * 
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the date of birth of the contact. Guaranteed to not be {@code null}.
     * 
     */
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * @return the gender of the contact. Guaranteed to not be {@code null}.
     * 
     */
    public Gender getGender()
    {
        return gender;
    }

    /**
     * <p>
     * Builder class used for constructing {@link Contact} objects.
     * </p>
     */
    public static class Builder
    {
        private String name;
        private Date dateOfBirth;
        private Gender gender;

        /**
         * @param name
         *            Designates the name to be used when the {@link Contact} is constructed.
         * @return The builder to be used for constructing the {@link Contact}.
         * @throws IllegalArgumentException
         *             if {@code name} is {@code null} or empty.
         */
        public Builder name(String name)
        {
            if (name == null || name.isEmpty())
            {
                throw new IllegalArgumentException("name cannot be null or empty");
            }
            this.name = name;
            return this;
        }

        /**
         * @param dateOfBirth
         *            Designates the date of birth to be used when the {@link Contact} is constructed.
         * @return The builder to be used for constructing the {@link Contact}.
         * @throws IllegalArgumentException
         *             if {@code dateOfBirth} is {@code null}.
         */
        public Builder dateOfBirth(Date dateOfBirth)
        {
            if (dateOfBirth == null)
            {
                throw new IllegalArgumentException("dateOfBirth cannot be null");
            }
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        /**
         * @param gender
         *            Designates the gender to be used when the {@link Contact} is constructed.
         * @return The builder to be used for constructing the {@link Contact}.
         * @throws IllegalArgumentException
         *             if {@code gender} is {@code null}.
         */
        public Builder gender(Gender gender)
        {
            if (gender == null)
            {
                throw new IllegalArgumentException("gender cannot be null");
            }
            this.gender = gender;
            return this;
        }

        /**
         * @return The {@link Contact} which was built using all of the previously set values on this builder.
         * @throws IllegalStateException
         *             If any of the following conditions are met
         *             <ul>
         *             <li>if {@code name} is {@code null} or empty</li>
         *             <li>if {@code dateOfBirth} is {@code null}</li>
         *             <li>if {@code gender} is {@code null}</li>
         *             </ul>
         */
        public Contact build()
        {
            validateRequiredAttributes();
            return new Contact(this);
        }

        private void validateRequiredAttributes()
        {
            if (name == null || name.isEmpty())
            {
                throw new IllegalStateException("name cannot be null or empty");
            }
            else if (dateOfBirth == null)
            {
                throw new IllegalStateException("dateOfBirth cannot be null");
            }
            else if (gender == null)
            {
                throw new IllegalStateException("gender cannot be null");
            }
        }
    }
}