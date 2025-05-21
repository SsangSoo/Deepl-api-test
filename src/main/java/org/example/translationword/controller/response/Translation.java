package org.example.translationword.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Translation {
    private String detected_source_language;
    private String text;

    @Builder
    private Translation(String detected_source_language, String text) {
        this.detected_source_language = detected_source_language;
        this.text = text;
    }
}
