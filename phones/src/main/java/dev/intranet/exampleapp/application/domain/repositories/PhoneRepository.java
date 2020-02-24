package dev.intranet.exampleapp.application.domain.repositories;

import dev.intranet.exampleapp.application.domain.Phone;

import java.util.List;
import java.util.Set;

public interface PhoneRepository {

    /**
     * @param numbers which you wanna find
     * @return a {@link java.util.List} of phones found
     */
     List<Phone> byNumbers(Set<String> numbers);

     long countPhones();

    /**
     *
     * @param phone which you wanna save
     * @return an instance of saved {@link Phone}
     */
     Phone save(Phone phone);

}
