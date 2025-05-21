package org.example.translationword.controller.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class DeeplRequest {
    private List<String> text;
    private String target_lang;

    @Builder
    private DeeplRequest(List<String> text) {
        this.text = text;
        this.target_lang = "KO";
    }

    public static DeeplRequest of(List<String> text) {
        return DeeplRequest.builder()
                .text(text)
                .build();
    }

    @Getter
    private enum LANGUAGE {
        KO("KO");

        private String lang;
        LANGUAGE(String lang) {
            lang = lang;
        }
    }
}
