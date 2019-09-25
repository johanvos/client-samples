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

    void notestGLFromJava(long nativeWindowPtr) throws GLException {
        egl = EGL.getEGL();
	// egl.testAll(nativeWindowPtr);
    }

    void testGLFromJava(long nativeWindowPtr) throws GLException {
	    // System.err.println("crash on brol");
	    // System.err.println("Length = "+brol.length());
	    // System.err.println("did not crash on brol");
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

        eglDisplay = egl.eglGetAndInitializeDisplay(nativeDisplay);
System.err.println("[ACC] got eglDisplay at "+eglDisplay);
        if (eglDisplay == EGL.EGL_NO_DISPLAY) {
            throw new GLException(egl.eglGetError(), "Could not get EGL display");
        }


System.err.println("[ACC] now call eglChooseConfig, eglConfigssize = "+eglConfigs.length+" and 0 = "+eglConfigs[0]+" and numconfsize = "+configCount.length+" and [0] = "+configCount[0]);
        // if (!egl.eglChooseConfig(eglDisplay, attributes, eglConfigs, 1, configCount)) {
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

