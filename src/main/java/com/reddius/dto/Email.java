package com.reddius.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Email implements Serializable {
    private String subject;
    private String recipient;
    private String body;

    public Email(String subject, String recipient, String body) {
        this.subject = subject;
        this.recipient = recipient;
        this.body = body;
    }

    public Email(){

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Email{" +
                "subject='" + subject + '\'' +
                ", recipient='" + recipient + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
