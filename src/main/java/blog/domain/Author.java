package blog.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", nullable = false)
    private
    Integer id;

    @Column(name = "user_id")
    private
    Integer user_id;

    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private
    User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Post> posts = new ArrayList();

    public Author(Integer user_id) {
        this.user_id = user_id;
    }
}
