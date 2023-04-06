package fergie.me.Data;

public enum MovieGenre {
    ACTION(1),
    DRAMA(2),
    TRAGEDY(3);

    private final Long id;

    public Long getGenreNum() {
        return id;
    }

    MovieGenre(long id) {
        this.id = id;
    }
}
