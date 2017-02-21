package blog.domain;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hibernate.annotations.CascadeType.REMOVE;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private
    Integer id;

    @Column(name = "title")
    private
    String title;

    @Column(name = "description")
    private
    String description;

    @Column(name = "content")
    private
    String content;

    @Column(name = "created_date")
    private
    Date created_date;

    @Column(name = "category_id")
    private
    Integer category_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private
    Category category;

    @Column(name = "tag_id")
    private
    Integer tag_id;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "posts")
    private
    List<Tag> tags = new ArrayList<>();

    @Column(name = "author_id")
    private
    Integer author_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private
    Author author;

    @Cascade(REMOVE)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    private List<Comment> comments = new ArrayList();



    public Post() {
    }

    public Post(String title, String description, String content, Date created_date, Integer category_id) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.created_date = created_date;
        this.category_id = category_id;
    }

    public Post(String title, String description, String content, Date created_date, Integer category_id, Integer tag_id, Integer author_id) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.created_date = created_date;
        this.category_id = category_id;
        this.tag_id = tag_id;
        this.author_id = author_id;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getTag_id() {
        return tag_id;
    }

    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

}
