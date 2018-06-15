package by.com.life.alice.service;

import by.com.life.alice.domain.PendingCommandType;


public interface CommandRecognizerService {
    PendingCommandType recognize(String text);
}
