package javaone.nashorn;

import com.oracle.avatar.js.Server;

import java.io.File;
import java.lang.reflect.Field;

public class Main {

    static {
        try {
            final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
            sysPathsField.setAccessible(true);
            sysPathsField.set(null, null);
            System.setProperty("java.library.path",
                    new File(Main.class.getResource("./libavatar-js.dylib").getPath())
                            .getParentFile().getCanonicalPath());
            System.loadLibrary("avatar-js");
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public static void main(String[] args) throws Throwable {
        Server.main(Main.class.getResource("/app.js").getPath());
    }
}
