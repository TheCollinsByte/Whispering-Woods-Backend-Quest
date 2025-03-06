package com.thecollinsbyte;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Challenge01Test {

    @Test
    void testBasicCase() {
        Challenge01 challenge = new Challenge01();
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Integer> expected = Map.of("apple", 3, "banana", 2, "orange", 1);

        assertEquals(expected, challenge.countWordFrequency(words));
    }

    @Test
    void testSingleWordRepeated() {
        Challenge01 challenge = new Challenge01();
        List<String> words = Arrays.asList("apple", "apple", "apple", "apple");
        Map<String, Integer> expected = Map.of("apple", 4);

        assertEquals(expected, challenge.countWordFrequency(words));
    }

    @Test
    void testEmptyList() {
        Challenge01 challenge = new Challenge01();
        List<String> words = Collections.emptyList();
        Map<String, Integer> expected = Collections.emptyMap();

        assertEquals(expected, challenge.countWordFrequency(words));
    }

    @Test
    void testWordsWithDifferentCases() {
        Challenge01 challenge = new Challenge01();
        List<String> words = Arrays.asList("Apple", "Banana", "Orange", "Apple", "Guava");
        Map<String, Integer> expected = Map.of("apple", 2, "orange", 1, "banana", 1, "guava", 1);

        assertEquals(expected, challenge.countWordFrequency(words));
    }

    @Test
    void testWordsWithPunctuations() {
        Challenge01 challenge = new Challenge01();
        List<String> words = Arrays.asList("word!", "word", "word,", "word.");
        Map<String, Integer> expected = Map.of("word!", 1, "word", 1, "word,", 1, "word.", 1);

        assertEquals(expected, challenge.countWordFrequency(words));
    }

    @Test
    void testWordsWithSpaces() {
        Challenge01 challenge = new Challenge01();
        List<String> words = Arrays.asList(" space", "space ", "space", " space ");
        Map<String, Integer> expected = Map.of("space", 4);
        assertEquals(expected, challenge.countWordFrequency(words));
    }

    @Test
    void testMixedWords() {
        Challenge01 challenge = new Challenge01();
        List<String> words = Arrays.asList("Apple", "apple", "APPLE", "banana", "BANANA", "Banana");
        Map<String, Integer> expected = Map.of("apple", 3,  "banana", 3);
        assertEquals(expected, challenge.countWordFrequency(words));
    }
}