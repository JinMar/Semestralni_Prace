package tul.ppj.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Marek on 11.05.2016.
 */
@Entity
@Table(name = "Images")
public class Images {

    private int id;
    private String url;
    private String name;
    private Date createDate;
    private Date updateDate;
    private Set<ImageTag> imageTags = new HashSet<>(0);
    private Set<Likes> likes = new HashSet<>(0);
    private Set<Comment> comments = new HashSet<>(0);
    private Autor autor;

    public Images(String url, String name, Date createDate, Date updateDate, Autor autor) {
        this.url = url;
        this.name = name;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.autor = autor;
    }
    public Images() {

    }


    @Id
    @Column(name = "ID_images")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "images")
    public Set<ImageTag> getImageTag() {
        return imageTags;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "images")
    public Set<Likes> getLikes() {
        return likes;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID")
    public Autor getAutor() { return autor; }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "images")
    public Set<Comment> getComments() { return comments;}

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setImageTag(Set<ImageTag> imageTags) {
        this.imageTags = imageTags;
    }

    public void setLikes(Set<Likes> likes) {
        this.likes = likes;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
