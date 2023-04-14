package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.CreateMovieDto;
import pl.edu.pwsztar.domain.entity.Movie;

import java.util.Optional;

@Component
public class MovieUpdateMapper {

    public Movie mapToMovie(CreateMovieDto createMovieDto, Optional<Movie> movieOptional){
        Movie movie = movieOptional.get();
        movie.setTitle(createMovieDto.getTitle());
        movie.setImage(createMovieDto.getImage());
        movie.setYear(createMovieDto.getYear());
        movie.setVideoId(createMovieDto.getVideoId());

        return movie;
    }
}
