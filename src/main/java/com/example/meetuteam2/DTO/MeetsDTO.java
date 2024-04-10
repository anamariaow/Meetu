package com.example.meetuteam2.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MeetsDTO {
    private Long id;
    private Integer quantity;
    private LocalDate releaseDate;

    public MeetsDTO(Long id, Integer quantity, LocalDate releaseDate) {
        this.id = id;
        this.quantity = quantity;
        this.releaseDate = releaseDate;
    }

    public MeetsDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
