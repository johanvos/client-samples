package hello;

public class HelloWorld {

    public static void main(String[] args) {
	try {
	System.err.println("HELLOWORLDMAIN, initiate instance");
        HelloWorld hw = new HelloWorld();
	System.err.println("HELLOWORLDMAIN, loadlib");
	System.loadLibrary("glass_android");
	System.err.println("HELLOWORLDMAIN, doneloadlib");
        hw.testMe();
	System.err.println("done testing");
	System.err.println("graal main entry gone!");
	} catch (Exception e) {
		System.err.println("Whoops, got exception!");
		e.printStackTrace();
		System.err.println("thas was the exception!");
	}
    }

    public void testMe() {
        System.out.println("Hello World!!");
        HelloGL hg = new HelloGL();
        long nativeWindowPtr = _getNativeHandle();
        try {
            hg.testGLFromJava(nativeWindowPtr);
        }
        catch (Throwable t) {
            t.printStackTrace();
        }
    }

    native long _getNativeHandle();

}
