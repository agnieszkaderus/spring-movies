package pl.edu.pwsztar.domain.dto;

import lombok.Data;

@Data
public class CounterDto {
    private Long counter;

    public CounterDto(Long counter) {
        this.counter = counter;
    }


}
