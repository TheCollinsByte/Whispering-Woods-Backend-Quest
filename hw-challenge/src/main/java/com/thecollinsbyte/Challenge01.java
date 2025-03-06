package com.thecollinsbyte;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a Program to find the frequency of each word in a given string
 */
public class Challenge01 {

    private static final Logger LOG = LoggerFactory.getLogger(Challenge01.class);

    public Map<String, Integer> countWordFrequency(List<String> words) {
        LOG.info("Words passed by the user: {}", words);
        Map<String, Integer> wordCount = new HashMap<>();

        if(words.isEmpty()) {
            return wordCount;
        }

        for (String word : words) {
            word = word.toLowerCase();
            word = word.trim();
            /*if(wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }*/
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            LOG.info("Words after converting to lowercase: {}", word);
        }

        return wordCount;
    }
}
