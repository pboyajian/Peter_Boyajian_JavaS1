package com.trilogyed.PeterBoyajianU1Capstone.model;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Game extends Item {
    @NotEmpty(message = "Game title cannot be empty.")
    private String title;
    @NotEmpty(message = "Game rating cannot be empty.")
    private String esrbRating;
    @NotEmpty(message = "Game description cannot be empty.")
    private String description;
    @NotEmpty(message = "Game studio cannot be empty.")
    private String studio;

    public Game() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return title.equals(game.title) &&
                esrbRating.equals(game.esrbRating) &&
                description.equals(game.description) &&
                studio.equals(game.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, esrbRating, description, studio);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
}
