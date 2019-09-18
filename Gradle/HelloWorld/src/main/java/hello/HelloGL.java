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
        int[] attributes = new int[]{8,8,8,8,16,1,1};
        egl = EGL.getEGL();

        System.err.println("EGLDISPLAY = "+eglDisplay);


        int configCount[] = {0};
        int major[] = {0}, minor[]={0};
        long nativeDisplay = 0;
        long nativeWindow = nativeWindowPtr;

System.err.println("nativeWindow = "+nativeWindow);
System.err.println("nativeDisplay = "+nativeDisplay);
// egl.testGraal(nativeWindow, major, minor, attributes, eglConfigs, configCount);

        if (nativeDisplay == -1l) { // error condition
            throw new GLException(0, "Could not get native display");
        }
        if (nativeWindow == -1l) { // error condition
            throw new GLException(0, "Could not get native window");
        }

        eglDisplay = egl.eglGetDisplay(nativeDisplay);
System.err.println("[ACC] got eglDisplay at "+eglDisplay);
        if (eglDisplay == EGL.EGL_NO_DISPLAY) {
            throw new GLException(egl.eglGetError(), "Could not get EGL display");
        }

        if (!egl.eglInitialize(eglDisplay, major, minor)) {
            throw new GLException(egl.eglGetError(), "Error initializing EGL");
        }
System.err.println("[ACC] egl initialized, now bind with API "+EGL.EGL_OPENGL_ES_API);
        if (!egl.eglBindAPI(EGL.EGL_OPENGL_ES_API)) {
            throw new GLException(egl.eglGetError(), "Error binding OPENGL API");
        }


System.err.println("[ACC] now call eglChooseConfig, eglConfigssize = "+eglConfigs.length+" and 0 = "+eglConfigs[0]+" and numconfsize = "+configCount.length+" and [0] = "+configCount[0]);
        if (!egl.eglChooseConfig(eglDisplay, attributes, eglConfigs, 1, configCount)) {
            throw new GLException(egl.eglGetError(), "Error choosing EGL config");
        }
System.err.println("[ACC] did call eglChooseConfig, eglConfigssize = "+eglConfigs.length+" and 0 = "+eglConfigs[0]+" and numconfsize = "+configCount.length+" and [0] = "+configCount[0]);

System.err.println("[ACC] call eglCreateWindowSurface");
}
}

