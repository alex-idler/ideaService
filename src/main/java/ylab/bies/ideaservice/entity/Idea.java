package ylab.bies.ideaservice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "ideas")
public class Idea {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID userId;
    private String name;
    private String text;
    private Long statusId;
    private Integer rating;

    public Idea() {
    }

    public Idea(UUID userId) {
        this.userId = userId;
        this.rating = 0;
        this.statusId = 1L;
    }

    public Idea(UUID userId, String name, String text) {
        this.userId = userId;
        this.name = name;
        this.text = text;
        this.rating = 0;
        this.statusId = 1L;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Idea idea = (Idea) o;
        return id != null && Objects.equals(id, idea.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
