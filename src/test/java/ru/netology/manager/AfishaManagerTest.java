package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieList;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

public class AfishaManagerTest {

    @Mock
    private AfishaRepository repository = Mockito.mock(AfishaRepository.class);

    @InjectMocks
    private AfishaManager manager = new AfishaManager(repository);
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
    private MovieList eleventh = new MovieList(11, "Quest", "thriller", "11");

    @BeforeEach
    public void setUp() {
        manager = new AfishaManager(repository);
    }

    @Test
    public void shouldAddMovies() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        MovieList[] returned = new MovieList[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();

        MovieList[] expected = new MovieList[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        MovieList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowLastTenIfTen() {
        MovieList[] returned = new MovieList[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();

        MovieList[] expected = new MovieList[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        MovieList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowNineMovies() {
        MovieList[] returned = new MovieList[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        doReturn(returned).when(repository).findAll();

        MovieList[] expected = new MovieList[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        MovieList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowLastFiveMovies() {
        MovieList[] returned = new MovieList[]{sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();

        MovieList[] expected = new MovieList[]{tenth, ninth, eighth, seventh, sixth};
        MovieList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowOneMovie() {
        MovieList[] returned = new MovieList[]{tenth};
        doReturn(returned).when(repository).findAll();

        MovieList[] expected = new MovieList[]{tenth};
        MovieList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowZeroMovies() {
        MovieList[] returned = new MovieList[]{};
        doReturn(returned).when(repository).findAll();

        MovieList[] expected = new MovieList[]{};
        MovieList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowAllMoviesWhenLessTen() {
        MovieList[] returned = new MovieList[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        MovieList[] expected = new MovieList[]{fifth, fourth, third, second, first};
        MovieList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowLastTenMoviesIfMore() {
        MovieList[] returned = new MovieList[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();

        MovieList[] expected = new MovieList[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        MovieList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

}