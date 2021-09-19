package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieList;
import org.junit.jupiter.api.Disabled;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;

public class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    private MovieList first = new MovieList(1, "Bloodshot", "thriller", "1");
    private MovieList second = new MovieList(2, "Forward", "cartoon", "2");
    private MovieList third = new MovieList(3, "Hotel Belgrade", "comedy", "3");
    private MovieList fourth = new MovieList(4, "Gentlemen", "actionMovie", "4");
    private MovieList fifth = new MovieList(5, "Invisible-Man", "horrors", "5");
    private MovieList sixth = new MovieList(6, "Trolls", "cartoon", "6");
    private MovieList seventh = new MovieList(7, "Number one", "comedy", "7");
    private MovieList eighth = new MovieList(8, "One breath", "drama", "8");
    private MovieList ninth = new MovieList(9, "Pinocchio", "fantasy", "9");
    private MovieList tenth = new MovieList(10, "Doll 2", "horrors", "10");

    @Test
    public void shouldFindAllMovies() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
        MovieList[] expected = new MovieList[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        MovieList[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyIfNoFilms() {

        MovieList[] expected = new MovieList[]{};
        MovieList[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveMovies() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        MovieList[] expected = new MovieList[]{first, second, third, fourth, fifth};
        MovieList[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindIfMoviesExists() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        int requestedId = 4;
        repository.findById(requestedId);
        MovieList expected = fourth;
        MovieList actual = repository.findById(requestedId);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullIfMoviesNotExists() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        int requestedId = 6;
        repository.findById(requestedId);
        MovieList expected = null;
        MovieList actual = repository.findById(requestedId);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExists() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        int removeId = 5;
        repository.removeById(removeId);
        MovieList[] expected = new MovieList[]{first, second, third, fourth};
        MovieList[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Disabled
    @Test
    public void shouldNotRemoveIfNotExists() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        int removeId = 6;
        repository.removeById(removeId);
        MovieList[] expected = new MovieList[]{first, second, third, fourth, fifth};
        MovieList[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.removeAll();
        MovieList[] expected = new MovieList[]{};
        MovieList[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}
