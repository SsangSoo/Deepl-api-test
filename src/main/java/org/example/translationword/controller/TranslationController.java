package org.example.translationword.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.translationword.config.DeeplProperty;
import org.example.translationword.controller.request.DeeplRequest;
import org.example.translationword.controller.request.TranslationRequest;
import org.example.translationword.controller.response.DeeplApiResponse;
import org.example.translationword.controller.response.DeeplResponse;
import org.example.translationword.controller.response.Translation;
import org.example.translationword.controller.response.TranslationResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TranslationController {

    private final DeeplProperty deeplProperty;
    private final static String DEEPL_URL = "https://api-free.deepl.com/v2/translate";
    
    @PostMapping("/api/translation")
    public ResponseEntity<TranslationResponse> retrieveTranslation(@RequestBody TranslationRequest request) {

        List<String> splitedRequestText = request.split();
        DeeplResponse response = callDeeplApi(DeeplRequest.of(splitedRequestText));

        List<String> wordList = splitedRequestText; // en
        List<DeeplApiResponse> translations = response.getTranslations(); // ko

        List<Translation> responseElements = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            responseElements.add(createTranslation(wordList, i, translations));
        }

        return ResponseEntity.ok(createResponseBody(responseElements));
    }

    /**
     * deepl api 호출
     * @param request
     * @return
     */
    private DeeplResponse callDeeplApi(DeeplRequest request) {

        log.info("request = {}", request);

        RestClient restClient = RestClient.create();

        return restClient
                .post()
                .uri(DEEPL_URL + "?target_lang=" + request.getTarget_lang())
                .header("Authorization", "DeepL-Auth-Key " + deeplProperty.getAuth())
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(DeeplResponse.class);

    }

    private Translation createTranslation(List<String> wordList, int i, List<DeeplApiResponse> translations) {
        return Translation.builder()
                .eng(wordList.get(i))
                .ko(translations.get(i).getText())
                .build();
    }

    private TranslationResponse createResponseBody(List<Translation> responseElements) {
        return TranslationResponse.builder().translations(responseElements).build();
    }


}
