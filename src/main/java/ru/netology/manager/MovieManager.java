package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.MovieList;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MovieManager {
    private MovieList[] movies = new MovieList[0];
    private int quantityMovies = 10;

    public MovieManager(int quantityMovies) {
        this.quantityMovies = quantityMovies;
    }

    public void add(MovieList movie) {
        int resultLength = movies.length + 1;
        MovieList[] tmp = new MovieList[resultLength];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public MovieList[] getMovies() {
        int resultLength = quantityMovies;
        if (movies.length < resultLength)
            resultLength = movies.length;
        MovieList[] result = new MovieList[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}

