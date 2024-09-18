package ru.yandex.practicum.catsgram.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@Data
@EqualsAndHashCode(of = {"id"})
public class Post implements Comparable<Post>{
    Long id;
    long authorId;
    String description;
    Instant postDate;

    @Override
    public int compareTo(Post post) {
        return this.postDate.compareTo(post.postDate);
    }
}
