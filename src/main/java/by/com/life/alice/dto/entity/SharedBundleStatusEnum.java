package by.com.life.alice.dto.entity;

public enum SharedBundleStatusEnum {
    NONE(0),
    MAIN(1),
    INVITED(2),
    INVITED_REJECTED(3),
    INVITE_REJECTED_AUTOMATICALLY(4),
    MEMBER(5),
    REMOVED(6),
    LEAVE_THE_GROUP(7);

    private Integer id;

    SharedBundleStatusEnum(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }
}
