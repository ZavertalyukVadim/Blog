package blog.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    public Author() {
    }

    public Integer getId() {
        return id;
    }

    public Author(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
