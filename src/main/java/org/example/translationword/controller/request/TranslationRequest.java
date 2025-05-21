package org.example.translationword.controller.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;

@Getter
@NoArgsConstructor
@ToString
public class TranslationRequest {
    private String text;

    @Builder
    private TranslationRequest(String text) {
        this.text = text;
    }

    public List<String> split() {
        Set<String> set = new LinkedHashSet<>();

        String[] words = text.split(" ");

        for (String word : words) {
            set.add(word);
        }

        set.add(text);

        return new ArrayList<>(set);

    }

}