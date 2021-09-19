package ru.netology.repository;

import ru.netology.domain.MovieList;

public class AfishaRepository {
    private MovieList[] movies = new MovieList[0];

    public void save(MovieList movie) {
        int length = movies.length + 1;
        MovieList[] tmp = new MovieList[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public MovieList[] findAll() {
        return movies;
    }

    public MovieList findById(int id) {
        for (MovieList movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        MovieList[] tmp = new MovieList[length];
        int index = 0;
        for (MovieList movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
            movies = tmp;
        }
    }

    public void removeAll() {
        movies = new MovieList[0];
    }
}



