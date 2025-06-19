package org.example.nawa5.service;

import org.example.nawa5.domain.Bookmark;
import org.example.nawa5.domain.Post;
import org.example.nawa5.domain.User;

import java.util.List;

public interface BookmarkService {

    /** 북마크 등록 **/
    void register(User user, Post post);

    /** 북마크 조회 **/
    List<Bookmark> gets();

    /** 북마크 삭제 **/
    void delete(Long id);
}
