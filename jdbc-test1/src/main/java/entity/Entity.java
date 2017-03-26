package entity;

/**
 * Created by unike on 23.03.2017.
 */
public abstract class Entity {

    private Long id;

    public Entity() {
    }

    public Entity(Long id) {
        this.id = id;
    }

    public Long getId() {
        if (null == id) return -1L;
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
