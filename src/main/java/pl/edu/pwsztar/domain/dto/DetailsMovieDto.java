package pl.edu.pwsztar.domain.dto;

import lombok.Data;

@Data
public class DetailsMovieDto {
    private String title;
    private String videoId;

    private String image;

    private String year;

    public DetailsMovieDto() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public String getVideoId() {
        return videoId;
    }

    @Override
    public String toString() {
        return "DetailsMovieDto{" +
                "title='" + title + '\'' +
                ", videoId='" + videoId + '\'' +
                '}';
    }
}
