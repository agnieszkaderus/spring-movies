package pl.edu.pwsztar.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MovieDto implements Serializable {

    private Long movieId;
    private String title;
    private String image;
    private Integer year;

    private String videoId;

    public MovieDto() {
    }

    public Long getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}
