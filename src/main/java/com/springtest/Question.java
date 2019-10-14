package com.springtest;

import java.util.Map;
import java.util.Set;

public class Question {
    private String name;
    private Map<String, Object> variant;
    private Set<String> answers;

    public Question(String name, Map<String, Object> variant, Set<String> answers) {
        this.name = name;
        this.variant = variant;
        this.answers = answers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getVariant() {
        return variant;
    }

    public void setVariant(Map<String, Object> variant) {
        this.variant = variant;
    }

    public Set<String> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<String> answers) {
        this.answers = answers;
    }
}
