package by.com.life.alice.dto.entity;

/**
 * Created by Aleksey.Shitikov on 15.05.2017.
 */
public enum MyLifeStatusEnum {

    BEGIN(0),
    ACTIVE(1),
    DELETED(2);

    private int status;

    MyLifeStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
