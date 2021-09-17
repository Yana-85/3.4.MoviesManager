package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieList;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    private MovieManager manager = new MovieManager();
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
    public void shouldShowDefaultQuantityMovies() {
        MovieManager manager = new MovieManager(10);
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

        MovieList[] expected = new MovieList[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        MovieList[] actual = manager.getMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowMoviesBelowLimitValue() {
        MovieManager manager = new MovieManager(9);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);

        MovieList[] expected = new MovieList[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        MovieList[] actual = manager.getMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastFiveMovies() {
        MovieManager manager = new MovieManager(5);
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

        MovieList[] actual = manager.getMovies();
        MovieList[] expected = new MovieList[]{tenth, ninth, eighth, seventh, sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowOneMovie() {
        MovieManager manager = new MovieManager(1);
        manager.add(tenth);
        MovieList[] expected = new MovieList[]{tenth};
        MovieList[] actual = manager.getMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetZeroMovies() {
        MovieManager manager = new MovieManager(0);
        MovieList[] expected = new MovieList[]{};
        MovieList[] actual = manager.getMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAllMoviesWhenLessTen() {
        MovieManager manager = new MovieManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        MovieList[] actual = manager.getMovies();
        MovieList[] expected = new MovieList[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOverMaxMovie() {
        MovieManager manager = new MovieManager(11);
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

        MovieList[] actual = manager.getMovies();
        MovieList[] expected = new MovieList[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}