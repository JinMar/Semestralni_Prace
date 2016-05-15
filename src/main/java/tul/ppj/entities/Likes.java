package tul.ppj.entities;

import javax.persistence.*;

/**
 * Created by Marek on 11.05.2016.
 */
@Entity
@Table(name = "Likes")
public class Likes {

    private int id;
    private int result;
    private Images images;

    public Likes() {

    }
    public Likes(int result, Images images) {
        this.result = result;
        this.images = images;
    }

    @Id
    @Column(name = "ID_likes")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    @Column(name = "Result")
    public int getResult() {
        return result;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_images")
    public Images getImages() {
        return images;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}
