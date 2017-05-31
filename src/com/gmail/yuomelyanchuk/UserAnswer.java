package com.gmail.yuomelyanchuk;

public  class UserAnswer {
    private final String lastName;
    private final String firstName;
    private final int age;
    private final boolean questionOneAns;
    private final boolean questionTwoAns;

    public UserAnswer(String lastName, String firstName, int age, boolean questionOneAns, boolean questionTwoAns) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.questionOneAns = questionOneAns;
        this.questionTwoAns = questionTwoAns;
    }

    public boolean isQuestionOneAns() {
        return questionOneAns;
    }

    public boolean isQuestionTwoAns() {
        return questionTwoAns;
    }
}
