package tul.ppj.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Marek on 11.05.2016.
 */
@Entity
@Table(name = "Comment")
public class Comment {

    private int id;
    private String description;
    private Date createDate;
    private Images images;
    private Autor autor;
    private Set<LikesComment> comments = new HashSet<>(0);

    public Comment(String description, Date createDate, Images images, Autor autor) {
        this.description = description;
        this.createDate = createDate;
        this.images = images;
        this.autor = autor;
    }
    public Comment() {

    }

    @Id
    @Column(name = "ID_Coment")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public Date getCreateDate() {
        return createDate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_images")
    public Images getImages() {
        return images;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID")
    public Autor getAutor() {
        return autor;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comment")
    public Set<LikesComment> getComments() {
        return comments;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setComments(Set<LikesComment> comments) {
        this.comments = comments;
    }
}
