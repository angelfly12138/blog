package com.nmys.story.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 后台统计对象
 * <p>
 * Created by hongfei.zhang
 */
@Data
public class Statistics implements Serializable {

    // 文章数
    private long articles = 10;
    // 页面数
    private long pages = 10;
    // 评论数
    private long comments = 10;
    // 分类数
    private long categories = 10;
    // 标签数
    private long tags = 10;
    // 附件数
    private long attachs = 10;

    public long getArticles() {
        return articles;
    }

    public void setArticles(long articles) {
        this.articles = articles;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public long getComments() {
        return comments;
    }

    public void setComments(long comments) {
        this.comments = comments;
    }

    public long getCategories() {
        return categories;
    }

    public void setCategories(long categories) {
        this.categories = categories;
    }

    public long getTags() {
        return tags;
    }

    public void setTags(long tags) {
        this.tags = tags;
    }

    public long getAttachs() {
        return attachs;
    }

    public void setAttachs(long attachs) {
        this.attachs = attachs;
    }
}
