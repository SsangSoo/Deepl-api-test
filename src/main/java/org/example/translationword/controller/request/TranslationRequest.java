package org.example.translationword.controller.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class TranslationRequest {
    private List<String> text;
    private String target_lang;

    @Builder
    private TranslationRequest(List<String> text, String target_lang) {
        this.text = text;
        this.target_lang = target_lang;
    }
}
