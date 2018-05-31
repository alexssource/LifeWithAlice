package by.com.life.alice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@AllArgsConstructor
@ToString
public class PendingCommand {
    private PendingCommandType type;
    private Object[] args;
}
