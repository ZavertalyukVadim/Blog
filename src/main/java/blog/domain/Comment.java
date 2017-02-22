package blog.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    private
    Integer id;

    @Column(name = "content")
    private
    String content;

    @Column(name = "created_time")
    private
    Date created_time;

    @Column(name = "user_id")
    private
    Integer user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    User user;

    @Column(name = "post_id")
    private
    Integer post_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    Post post;

    public Comment() {
    }

    public Comment(String content, Date created_time, Integer post_id) {
        this.content = content;
        this.created_time = created_time;
        this.post_id = post_id;
    }

    public Comment(String content, Date created_time, Integer user_id, Integer post_id) {
        this.content = content;
        this.created_time = created_time;
        this.user_id = user_id;
        this.post_id = post_id;
    }
}
