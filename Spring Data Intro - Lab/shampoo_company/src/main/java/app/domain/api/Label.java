package app.domain.api;

import java.io.Serializable;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface Label extends Serializable {

    Long getId();

    void setId(Long id);

    String getTitle();

    void setTitle(String title);

    String getSubTitle();

    void setSubTitle(String subTitle);
}

