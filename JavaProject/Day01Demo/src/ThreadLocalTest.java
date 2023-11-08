import java.text.SimpleDateFormat;
import java.util.function.Supplier;

public class ThreadLocalTest {

    private static final  ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
/*
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(new Supplier<SimpleDateFormat>() {
        @Override
        public SimpleDateFormat get() {
            return new SimpleDateFormat("yyyyMMdd HHmm");
        }});
*/

    public static void main(String[] args) {
//        Thread
    }
}
