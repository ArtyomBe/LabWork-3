import animals.humans.Luis;
import java.lang.reflect.Method;
public class DumpMethods {
    public static void main(String[] args)
    {
        try {
            Class<Luis> c = Luis.class;
            Method[] m = c.getDeclaredMethods();
            for (Method method : m) System.out.println(method.toString());
        }
        catch (Throwable e){
            System.err.println(e);
        }
    }
}