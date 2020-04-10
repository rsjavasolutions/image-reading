package rs.java.ocrsystem.model;

import javax.persistence.*;

@Entity
@Table(name = "graphics")
public class Graphic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String url;
    private String content;

    public Graphic() {
    }

    public Graphic(String url, String content) {
        this.url = url;
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
