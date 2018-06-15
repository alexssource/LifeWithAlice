package by.com.life.alice.domain;


import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommandPattern {
    private PendingCommandType command;
    private String pattern;
}
