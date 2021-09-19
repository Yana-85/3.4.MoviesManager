package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.MovieList;
import ru.netology.repository.AfishaRepository;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AfishaManager {
    private AfishaRepository repository;
    private int quantityMovies = 10;

    public AfishaManager(int quantityMovies) {
        this.quantityMovies = quantityMovies;
    }

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public void add(MovieList movie) {
        repository.save(movie);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void findById(int id) {
        repository.findById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }

    public MovieList[] getAll() {
        MovieList[] movies = repository.findAll();
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




