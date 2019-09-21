package SQL;

public class UserInfo {
    private int id;
    private String name;
    private String password;
    private int age;
    @Override
    public String toString(){
        return "UserInfo[id="+id+",name="+name+",password="+password+",age="+age+"]";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
