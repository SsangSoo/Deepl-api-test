package org.example.translationword.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Translation {

    private String eng;
    private String ko;

    @Builder
    private Translation(String eng, String ko) {
        this.eng = eng;
        this.ko = ko;
    }
}
