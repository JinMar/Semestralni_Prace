package tul.ppj.entities;

import javax.persistence.*;

/**
 * Created by Marek on 11.05.2016.
 */
@Entity
@Table(name = "LikesComment")
public class LikesComment {

    private int id;
    private int result;

    private Comment comment;

    public LikesComment(int result, Comment comment) {
        this.result = result;
        this.comment = comment;
    }

    @Id
    @Column(name = "ID_LK")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    @Column(name = "Result")
    public int getResult() {
        return result;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Coment")
    public Comment getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setResult(int result) {
        this.result = result;
    }



    public void setComment(Comment comment) {
        this.comment = comment;
    }

}
