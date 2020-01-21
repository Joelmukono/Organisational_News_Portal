package models;

import java.util.Objects;

public class News {


    int newsId;
    String description;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return newsId == news.newsId &&
                Objects.equals(description, news.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsId, description);
    }

    public News(int newsId, String description){
        this.description = description;
        this.newsId = newsId;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
