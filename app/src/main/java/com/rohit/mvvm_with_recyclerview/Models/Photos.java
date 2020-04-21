package com.rohit.mvvm_with_recyclerview.Models;

import java.util.List;

public class Photos {

    private Integer page;
    private Integer pages;
    private Integer perpage;
    private Integer total;
    private List<User> photo = null;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPerpage() {
        return perpage;
    }

    public void setPerpage(Integer perpage) {
        this.perpage = perpage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<User> getPhoto() {
        return photo;
    }

    public void setPhoto(List<User> photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Photos{" +
                "page=" + page +
                ", pages=" + pages +
                ", perpage=" + perpage +
                ", total=" + total +
                ", photo=" + photo +
                '}';
    }
}
