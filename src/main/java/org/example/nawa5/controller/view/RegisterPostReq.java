package org.example.nawa5.controller.view;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.PostCategory;

@Getter
@RequiredArgsConstructor
public class RegisterPostReq {
    private final String name;
    private final PostCategory category;
    private final String title;
    private final String content;
    private final String mainImageUrl;
}
