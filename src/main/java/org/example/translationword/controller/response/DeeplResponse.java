package org.example.translationword.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class DeeplResponse {
    private List<DeeplApiResponse> translations;

    @Builder
    private DeeplResponse(List<DeeplApiResponse> translations) {
        this.translations = translations;
    }
}
