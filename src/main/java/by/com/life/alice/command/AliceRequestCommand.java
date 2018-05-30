package by.com.life.alice.command;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AliceRequestCommand {
    private AliceMetaCommand meta;
    private AliceRequestPayloadCommand request;
    private AliceSessionCommand session;
    private String version;
}
