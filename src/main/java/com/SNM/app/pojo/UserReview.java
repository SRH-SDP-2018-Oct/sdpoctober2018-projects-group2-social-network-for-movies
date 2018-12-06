package com.SNM.app.pojo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "userreview")
public class UserReview {
    @EmbeddedId
    public CompositeKeyUserReview compositeKeyUserReview;

    @Column(name = "review")
    private String review;

    public CompositeKeyUserReview getCompositeKeyUserReview() {
        return compositeKeyUserReview;
    }

    public void setCompositeKeyUserReview(CompositeKeyUserReview compositeKeyUserReview)
    {
        this.compositeKeyUserReview = compositeKeyUserReview;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
