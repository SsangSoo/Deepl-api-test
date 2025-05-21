package org.example.translationword.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.translationword.config.DeeplProperty;
import org.example.translationword.controller.request.TranslationRequest;
import org.example.translationword.controller.response.TranslationResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TranslationController {

    private final DeeplProperty deeplProperty;
    private final static String DEEPL_URL = "https://api-free.deepl.com/v2/translate";
    
    @PostMapping("/api/translation")
    public ResponseEntity<TranslationResponse> retrieveTranslation(@RequestBody TranslationRequest request) {
        log.info("request = {}", request);
        TranslationResponse response = callDeeplApi(request);
        return ResponseEntity.ok(response);
    }


    /**
     * deepl api 호출
     * @param request
     * @return
     */
    private TranslationResponse callDeeplApi(TranslationRequest request) {

        RestClient restClient = RestClient.create();

        return restClient
                .post()
                .uri(DEEPL_URL + "?target_lang=" + request.getTarget_lang())
                .header("Authorization", "DeepL-Auth-Key " + deeplProperty.getAuth())
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(TranslationResponse.class);

    }

}
