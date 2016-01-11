package services;

import model.Address;
import model.Book;
import model.Person;

import java.util.List;

/**
 * (c) Roman Gordeev
 * <p/>
 * 2014 июн 18
 */
public interface StorageService
{
    void add(String personName, String phone, String address);

    void delete(Long ID);

    List<Person> list();

    Book defaultBook();

    void close();

    void update(Long ID, String personName, String phone, String address);
}
