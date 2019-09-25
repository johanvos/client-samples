package hello;

import java.lang.reflect.Field;
import java.security.Permission;
import java.util.Formatter;

public class EGL {
    private static long eglWindowSurface = 0l;
    private static EGL instance = new EGL();
    private EGL() {}

    static EGL getEGL() {
        return instance;
    }

    // native boolean eglBindAPI(int api);

    // native boolean eglChooseConfig();

    native long eglCreateContext(); 

    long eglCreateWindowSurface() { 
        eglWindowSurface = _eglCreateWindowSurface();
        return eglWindowSurface;
    }

    native long _eglCreateWindowSurface();

    native long eglGetAndInitializeDisplay(long nativeDisplay);

    native int eglGetError();

    native boolean eglMakeCurrent(); 


    String eglErrorToString(int errorCode) {
        if (errorCode >= 0x3000 && errorCode < 0x3020) {
            for (Field field : EGL.class.getFields()) {
                try {
                    if (field.getName().startsWith("EGL_")
                            && field.getType() == Integer.TYPE
                            && field.getInt(null) == errorCode) {
                        return field.getName();
                    }
                } catch (IllegalAccessException e) {
                }
            }
        }
        return new Formatter()
                .format("0x%04x", errorCode & 0xffff)
                .out()
                .toString();
    }

}
