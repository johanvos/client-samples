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

    void testGLFromJava(long nativeWindowPtr) throws GLException {
        egl = EGL.getEGL();

        System.err.println("EGLDISPLAY = "+eglDisplay);


        int configCount[] = {0};
        int major[] = {0}, minor[]={0};
        long nativeDisplay = 0;
        long nativeWindow = nativeWindowPtr;

        System.err.println("nativeWindow = "+nativeWindow+", nativeDisplay = "+nativeDisplay);

        eglDisplay = egl.eglGetAndInitializeDisplay(nativeDisplay);
        System.err.println("[ACC] got eglDisplay at "+eglDisplay);

        System.err.println("[ACC] now call eglCreateWindowSurface");
        long eglSurface = egl.eglCreateWindowSurface(); 
        System.err.println("[ACC] now call eglCreateContext");
        long eglContext = egl.eglCreateContext();
        System.err.println("[ACC] now call eglMakeCurrent");

        egl.eglMakeCurrent();
        System.err.println("[ACC] DONE call eglMakeCurrent");



    }
}

