package pl.edu.pwsztar.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.CreateMovieDto;
import pl.edu.pwsztar.domain.dto.DetailsMovieDto;
import pl.edu.pwsztar.domain.dto.MovieDto;
import pl.edu.pwsztar.domain.entity.Movie;
import pl.edu.pwsztar.domain.mapper.MovieDetailsMapper;
import pl.edu.pwsztar.domain.mapper.MovieListMapper;
import pl.edu.pwsztar.domain.mapper.MovieMapper;
import pl.edu.pwsztar.domain.mapper.MovieUpdateMapper;
import pl.edu.pwsztar.domain.repository.MovieRepository;
import pl.edu.pwsztar.service.MovieService;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);

    private final MovieRepository movieRepository;
    private final MovieListMapper movieListMapper;
    private final MovieMapper movieMapper;
    private final MovieDetailsMapper movieDetailsMapper;
    private final MovieUpdateMapper movieUpdateMapper;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository,
                            MovieListMapper movieListMapper,
                            MovieMapper movieMapper,
                            MovieDetailsMapper movieDetailsMapper, MovieUpdateMapper movieUpdateMapper) {

        this.movieRepository = movieRepository;
        this.movieListMapper = movieListMapper;
        this.movieMapper = movieMapper;
        this.movieDetailsMapper = movieDetailsMapper;
        this.movieUpdateMapper = movieUpdateMapper;
    }

    @Override
    public List<MovieDto> findAll() {
        List<Movie> movies = movieRepository.findByOrderByYearDesc();
        return movieListMapper.mapToDto(movies);
    }

    @Override
    public void creatMovie(CreateMovieDto createMovieDto) {
        Movie movie = movieMapper.mapToEntity(createMovieDto);
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }

    @Override
    public DetailsMovieDto findMovie(Long movieId) {
        Movie movie = movieRepository.findOneByMovieId(movieId);

        if(movie == null) {
            return new DetailsMovieDto();
        }
        return movieDetailsMapper.mapToDto(movie);
    }

    @Override
    public void updateMovie(Long movieId, CreateMovieDto createMovieDto) {
        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        if(movieOptional.isPresent()){
            movieRepository.save(movieUpdateMapper.mapToMovie(createMovieDto, movieOptional));
        }
    }
// wersja bez Optionala i Mappera
//    @Override
//    public void updateMovie(Long movieId, CreateMovieDto createMovieDto) {
//        Movie movie = movieRepository.findOneByMovieId(movieId);
//        movie.setTitle(createMovieDto.getTitle());
//        movie.setImage(createMovieDto.getImage());
//        movie.setYear(createMovieDto.getYear());
//        movie.setVideoId(createMovieDto.getVideoId());
//        movieRepository.save(movie);
//    }

}
