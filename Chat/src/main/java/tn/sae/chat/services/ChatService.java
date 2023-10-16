package tn.sae.chat.services;



import tn.sae.chat.exceptions.ChatAlreadyExistException;
import tn.sae.chat.exceptions.ChatNotFoundException;
import tn.sae.chat.exceptions.NoChatExistsInTheRepository;
import tn.sae.chat.model.Chat;
import tn.sae.chat.model.Message;

import java.util.HashSet;
import java.util.List;

public interface ChatService {

    public Chat addChat(Chat chat) throws ChatAlreadyExistException;

    List<Chat> findallchats() throws NoChatExistsInTheRepository;

    Chat getById(int id)  throws ChatNotFoundException;

    HashSet<Chat> getChatByFirstUserName(String username)  throws ChatNotFoundException;

    HashSet<Chat> getChatBySecondUserName(String username)  throws ChatNotFoundException;

    HashSet<Chat> getChatByFirstUserNameOrSecondUserName(String username)  throws ChatNotFoundException;

    HashSet<Chat> getChatByFirstUserNameAndSecondUserName(String firstUserName, String secondUserName)  throws ChatNotFoundException;

    Chat addMessage(Message add, int chatId)  throws ChatNotFoundException;
}
