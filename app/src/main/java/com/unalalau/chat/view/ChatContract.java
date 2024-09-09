package com.unalalau.chat.view;

import java.util.List;

import com.unalalau.chat.model.MessageModel;

public interface ChatContract {

    void showConversations(List<MessageModel> conversations);

    void showMessageSentConfirmation();
}
