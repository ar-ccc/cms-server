package com.arccc.cmsserver.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 *
 * @TableName article_details
 */
@TableName(value ="article_details")
public class ArticleDetails implements Serializable {
    /**
     * 与文章的id绑定
     */
    @TableId(type = IdType.INPUT)
    private Integer id;

    /**
     *
     */
    private String mainTitle;

    /**
     *
     */
    private String subTitle;

    /**
     *
     */
    private String description;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 与文章的id绑定
     */
    public Integer getId() {
        return id;
    }

    /**
     * 与文章的id绑定
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     */
    public String getMainTitle() {
        return mainTitle;
    }

    /**
     *
     */
    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    /**
     *
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     *
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    /**
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ArticleDetails other = (ArticleDetails) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMainTitle() == null ? other.getMainTitle() == null : this.getMainTitle().equals(other.getMainTitle()))
            && (this.getSubTitle() == null ? other.getSubTitle() == null : this.getSubTitle().equals(other.getSubTitle()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMainTitle() == null) ? 0 : getMainTitle().hashCode());
        result = prime * result + ((getSubTitle() == null) ? 0 : getSubTitle().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mainTitle=").append(mainTitle);
        sb.append(", subTitle=").append(subTitle);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
