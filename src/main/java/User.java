import org.springframework.beans.factory.annotation.Value;

public class User {
    @Value("${spring.version}")
    public static String springVersion;

    public static void getVersion(){
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(springVersion);
    }
}
