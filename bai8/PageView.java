package baitapcolection.bai8;

import java.time.Instant;
import java.util.Objects;

public class PageView {
    private String userId;
    private String pageUrl;
    private Instant timestamp;

    public PageView() {
    }

    public PageView(String userId, String pageUrl, Instant timestamp) {
        this.userId = userId;
        this.pageUrl = pageUrl;
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageView pageView = (PageView) o;
        return userId == pageView.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId);
    }

    @Override
    public String toString() {
        return "PageView{" +
                "userId=" + userId +
                ", pageUrl='" + pageUrl + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
