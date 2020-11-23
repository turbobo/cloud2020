import java.time.ZonedDateTime;

/**
 * @Author Jusven
 * @Date 2020/11/23 9:53
 * 获取时区
 */
public class T2 {
    public static void main(String[] args) {
        // 默认时区
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
