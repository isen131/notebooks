package services;

import com.google.inject.Singleton;
import model.Address;
import model.Book;
import model.Person;
import model.Phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * (c) Roman Gordeev
 * <p/>
 * 2014 июн 18
 */
@Singleton
public class InMemoryStorage implements StorageService
{
    @Override
    public void delete(Long ID)
    {
    }

    @Override
    public void update(Long ID, String personName, String phone, String address)
    {}

    @Override
    public void add(String personName, String phone, String address)
    {
        Person person = new Person(personName);

        person.getPhones().add(new Phone(person, phone));
        book.getPersons().add(person);
    }

    @Override
    public List<Person> list()
    {
        List<Person> copy = new ArrayList<Person>(book.getPersons());
        Collections.sort(copy, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        return copy;
    }

    public Book defaultBook()
    {
        return book == null ? book = new Book() : book;
    }

    @Override
    public void close()
    {
        book = null;
    }

    private Book book;
}
