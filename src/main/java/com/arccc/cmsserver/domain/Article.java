package com.arccc.cmsserver.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章类
 * @TableName article
 */
public class Article implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String mainTitle;

    /**
     *
     */
    private String subTitlte;

    /**
     *
     */
    private String author;

    /**
     *
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public Integer getId() {
        return id;
    }

    /**
     *
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
    public String getSubTitlte() {
        return subTitlte;
    }

    /**
     *
     */
    public void setSubTitlte(String subTitlte) {
        this.subTitlte = subTitlte;
    }

    /**
     *
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     */
    public void setDate(Date date) {
        this.date = date;
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
        Article other = (Article) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMainTitle() == null ? other.getMainTitle() == null : this.getMainTitle().equals(other.getMainTitle()))
            && (this.getSubTitlte() == null ? other.getSubTitlte() == null : this.getSubTitlte().equals(other.getSubTitlte()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMainTitle() == null) ? 0 : getMainTitle().hashCode());
        result = prime * result + ((getSubTitlte() == null) ? 0 : getSubTitlte().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
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
        sb.append(", subTitlte=").append(subTitlte);
        sb.append(", author=").append(author);
        sb.append(", date=").append(date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
