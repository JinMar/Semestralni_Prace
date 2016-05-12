package tul.ppj.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Marek on 12.05.2016.
 */
@Entity
@Table(name = "ImageTag")
public class ImageTag implements Serializable {
    private Tags tags;
    private Images images;

    public ImageTag(Tags tags, Images images) {
        this.tags = tags;
        this.images = images;
    }
    public ImageTag() {

    }
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_tags")
    public Tags getTags() {
        return tags;
    }
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_images")
    public Images getImages() {
        return images;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}
