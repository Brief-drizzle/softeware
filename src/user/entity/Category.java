package user.entity;

import java.io.Serializable;

/**
 * (Category)实体类
 *项目类别
 * @author makejava
 * @since 2021-01-25 10:10:11
 */
public class Category implements Serializable {
    private static final long serialVersionUID = -47935327297104472L;

    private String categoryId;

    private String categoryName;


    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}