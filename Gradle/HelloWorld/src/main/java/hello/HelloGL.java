package hello;

public class HelloGL {

    private static long glesLibraryHandle;
    private static long eglLibraryHandle;
    private static boolean initialized = false;
    private long eglSurface;
    private long eglContext;
    private long eglDisplay;
    private EGL egl;
    long eglConfigs[] = {0};
    private String brol = null;

    void testGLFromJava(long nativeWindowPtr) throws GLException {
        egl = EGL.getEGL();

        System.err.println("EGLDISPLAY = "+eglDisplay);


        int configCount[] = {0};
        int major[] = {0}, minor[]={0};
        long nativeDisplay = 0;
        long nativeWindow = nativeWindowPtr;

System.err.println("nativeWindow = "+nativeWindow);
System.err.println("nativeDisplay = "+nativeDisplay);

        eglDisplay = egl.eglGetAndInitializeDisplay(nativeDisplay);
System.err.println("[ACC] got eglDisplay at "+eglDisplay);
        if (eglDisplay == EGL.EGL_NO_DISPLAY) {
            throw new GLException(egl.eglGetError(), "Could not get EGL display");
        }


System.err.println("[ACC] now call eglChooseConfig, eglConfigssize = "+eglConfigs.length+" and 0 = "+eglConfigs[0]+" and numconfsize = "+configCount.length+" and [0] = "+configCount[0]);
        if (!egl.eglChooseConfig()) {
            throw new GLException(egl.eglGetError(), "Error choosing EGL config");
        }
System.err.println("[ACC] did call eglChooseConfig, eglConfigssize = "+eglConfigs.length+" and 0 = "+eglConfigs[0]+" and numconfsize = "+configCount.length+" and [0] = "+configCount[0]);
System.err.println("[ACC] now call eglCreateWindowSurface");
long eglSurface = egl.eglCreateWindowSurface(eglDisplay, eglConfigs[0], nativeWindow);
System.err.println("[ACC] now call eglCreateContext");
long eglContext = egl.eglCreateContext(eglDisplay, eglConfigs[0]);
System.err.println("[ACC] now call eglMakeCurrent");

egl.eglMakeCurrent(eglDisplay, eglSurface, eglSurface, eglContext);
System.err.println("[ACC] DONE call eglMakeCurrent");



    }
}

