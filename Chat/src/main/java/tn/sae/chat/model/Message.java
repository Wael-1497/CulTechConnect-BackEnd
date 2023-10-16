package tn.sae.chat.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "message")
public class Message {
    @Id
    private int id;
    private String senderEmail;
    private Date time = new Date(System.currentTimeMillis());
    private String replymessage;
    @ManyToOne
    @JoinColumn(name = "chat_id") // Specify the name of the foreign key column
    private Chat chat; // This property establishes the relationship

    public Message() {
    }

    public Message(String senderEmail, Date time, String replymessage) {
        this.senderEmail = senderEmail;
        this.time = time;
        this.replymessage = replymessage;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getReplymessage() {
        return replymessage;
    }

    public void setReplymessage(String replymessage) {
        this.replymessage = replymessage;
    }



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
