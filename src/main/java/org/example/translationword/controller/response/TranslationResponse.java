package org.example.translationword.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class TranslationResponse {
    private List<Translation> translations;

    @Builder
    private TranslationResponse(List<Translation> translations) {
        this.translations = translations;
    }
}
