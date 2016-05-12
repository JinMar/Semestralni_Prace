package tul.ppj.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Marek on 11.05.2016.
 */
@Entity
@Table(name = "Autor")
public class Autor {

    private int id;
    private Date createDate;
    private String name;
    private Set<Images> images = new HashSet<>(0);
    private Set<Comment> comments = new HashSet<>(0);
    public Autor() {


    }
    public Autor(String name, Date createDate) {
        this.name = name;
        this.createDate = createDate;

    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    @Column(name = "createDate")
    public Date getCreateDate() {
        return createDate;
    }
    @Column(name = "Name")
    public String getName() {
        return name;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "autor")
    public Set<Images> getImages() {
        return images;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "images")
    public Set<Comment> getComments() { return comments;}
    public void setId(int id) {
        this.id = id;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImages(Set<Images> images) {
        this.images = images;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
