package app.domain.shampoo;

import app.dao.api.shampoo.interfaces.Label;

import javax.persistence.*;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
@Entity
public class ClassicLabel implements Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String title;
    @Basic
    private String subTitle;

    public ClassicLabel() {
    }

    public ClassicLabel(String title, String subTitle) {
        this.setTitle(title);
        this.setSubTitle(subTitle);
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getSubTitle() {
        return this.subTitle;
    }

    @Override
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
