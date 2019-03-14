package sl.nim.netease.com.gitlijar.been;

public class MessageEvent {
    private String name;
    private String age;

    public MessageEvent(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MessageEvent{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
