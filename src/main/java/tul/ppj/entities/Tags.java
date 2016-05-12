package tul.ppj.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Marek on 11.05.2016.
 */
@Entity
@Table(name = "Tags")
public class Tags {

    private int id;
    private String tag;
    private Set<ImageTag> imageTags = new HashSet<>(0);

    public Tags(String tag) {
        this.tag = tag;
    }
    public Tags() {

    }

    @Id
    @Column(name = "ID_tags")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    @Column(name = "Tag")
    public String getTag() {
        return tag;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    public Set<ImageTag> getImageTags() {
        return imageTags;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setImageTags(Set<ImageTag> imageTags) {
        this.imageTags = imageTags;
    }
}
