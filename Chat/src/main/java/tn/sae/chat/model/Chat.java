package tn.sae.chat.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chat")
public class Chat {
    @Transient
    public static final String SEQUENCE_NAME = "chat_sequence";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatId;
    private String firstUserName;
    private String secondUserName;
    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    private List<Message> messageList;

    public Chat() {
    }

    public Chat(int chatId, String firstUserName, String secondUserName, List<Message> messageList) {
        this.chatId = chatId;
        this.firstUserName = firstUserName;
        this.secondUserName = secondUserName;
        this.messageList = messageList;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public String getFirstUserName() {
        return firstUserName;
    }

    public void setFirstUserName(String firstUserName) {
        this.firstUserName = firstUserName;
    }

    public String getSecondUserName() {
        return secondUserName;
    }

    public void setSecondUserName(String secondUserName) {
        this.secondUserName = secondUserName;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
