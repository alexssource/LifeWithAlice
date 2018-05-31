package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.Forwarding;

import java.io.Serializable;

/**
 * Created by Sergey Horonzhyn on 5/29/15.
 */
public class JSONForwarding implements Serializable {

    private String all;
    private String busy;
    private String noReply;
    private String noReachable;

    //Build JSONForwarding from real billing object
    public JSONForwarding(Forwarding forwarding) {
        this.all = forwarding.getAll();
        this.busy = forwarding.getBusy();
        this.noReply = forwarding.getNoReply();
        this.noReachable = forwarding.getNoReachable();
    }
    
    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getBusy() {
        return busy;
    }

    public void setBusy(String busy) {
        this.busy = busy;
    }

    public String getNoReply() {
        return noReply;
    }

    public void setNoReply(String noReply) {
        this.noReply = noReply;
    }

    public String getNoReachable() {
        return noReachable;
    }

    public void setNoReachable(String noReachable) {
        this.noReachable = noReachable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JSONForwarding that = (JSONForwarding) o;

        if (all != null ? !all.equals(that.all) : that.all != null) return false;
        if (busy != null ? !busy.equals(that.busy) : that.busy != null) return false;
        if (noReply != null ? !noReply.equals(that.noReply) : that.noReply != null) return false;
        return !(noReachable != null ? !noReachable.equals(that.noReachable) : that.noReachable != null);

    }

    @Override
    public int hashCode() {
        int result = all != null ? all.hashCode() : 0;
        result = 31 * result + (busy != null ? busy.hashCode() : 0);
        result = 31 * result + (noReply != null ? noReply.hashCode() : 0);
        result = 31 * result + (noReachable != null ? noReachable.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Forwarding{" +
                "all='" + all + '\'' +
                ", busy='" + busy + '\'' +
                ", noReply='" + noReply + '\'' +
                ", noReachable='" + noReachable + '\'' +
                '}';
    }
}
