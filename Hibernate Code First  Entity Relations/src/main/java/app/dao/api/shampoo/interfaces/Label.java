package app.dao.api.shampoo.interfaces;

import java.io.Serializable;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface Label extends Serializable {

    long getId();

    void setId(long id);

    String getTitle();

    void setTitle(String title);

    String getSubTitle();

    void setSubTitle(String subTitle);
}

