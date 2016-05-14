package tul.ppj.DTO;

/**
 * Created by Marek on 14.05.2016.
 */
public class CommentDTO {
    private int likes;
    private int dislikes;
    private String text;
    private int id;

    public CommentDTO(int likes, int dislikes, String text,int id) {
        this.likes = likes;
        this.dislikes = dislikes;
        this.text = text;
        this.id=id;
    }

    public CommentDTO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
