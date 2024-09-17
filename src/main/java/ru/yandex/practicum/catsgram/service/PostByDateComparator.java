package ru.yandex.practicum.catsgram.service;

import ru.yandex.practicum.catsgram.model.Post;

import java.util.Comparator;

public class PostByDateComparator implements Comparator<Post> {

    @Override
    public int compare(Post o1, Post o2) {
        if(o1.equals(o2)) {
            return 0;
        } else if (o1.getPostDate().isBefore(o2.getPostDate())) {
            return -1;
        } else {
            return 1;
        }
    }
}
