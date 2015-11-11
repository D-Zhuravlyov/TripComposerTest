package tripComposer.model;

/**
 * Created by D.Zh.
 */
public class POSTKey {

    private String key;
    private String echo;

    public POSTKey() {
    }

    public POSTKey(String key, String echo) {
        this.key = key;
        this.echo = echo;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }

    @Override
    public String toString() {
        return "POSTKey{" +
                "key='" + key + '\'' +
                ", echo='" + echo + '\'' +
                '}';
    }
}
