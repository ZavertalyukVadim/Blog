package blog.domain;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "persistent_logins")
public class Login {

    @Column(name = "username")
    private String username;

    @Id
    @Column(name = "series")
    private String series;

    @Column(name = "token")
    private String token;

    @Column(name = "last_used")
    private Timestamp last_used;

    public Login() {
    }

    public Login(String username, String series, String token, Timestamp last_user) {
        this.username = username;
        this.series = series;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getLast_used() {
        return last_used;
    }

    public void setLast_used(Timestamp last_used) {
        this.last_used = last_used;
    }
}
