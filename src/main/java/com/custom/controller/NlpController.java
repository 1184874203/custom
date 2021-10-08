package com.custom.controller;

import com.custom.dto.NLP.NlpResp;
import com.custom.utils.GetWords;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: 邵禹寒
 * @date: 2021-09-07 17:07
 */
@RestController
@RequestMapping("NLP")
public class NlpController {

    @Resource
    private GetWords getWords;


    @GetMapping("/semantics/{text}")
    public List<NlpResp> getWords(@PathVariable("text") String text) {
        return getWords.getWords(text);
    }

    @GetMapping("/verbs/{text}")
    public List<String> getVerbs(@PathVariable("text") String text) {
        return getWords.getWords(text).stream()
                .filter(w -> w.getNature().equals("v"))
                .map(w -> w.getWord())
                .collect(Collectors.toList());
    }

}
