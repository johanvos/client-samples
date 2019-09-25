package hello;

public class HelloWorld {

    public static void main(String[] args) {
        try {
            System.err.println("HelloWorld main is called.");
            HelloWorld hw = new HelloWorld();
            System.err.println("HelloWorld instance created, load native lib with EGL implementations");
            System.loadLibrary("glass_android");
            System.err.println("HelloWorld Native lib is loaded, start testing");
            hw.testMe();
            System.err.println("HelloWorld done testing");
            System.err.println("HelloWorld graal entry has done its job!");
	} catch (Throwable e) {
            System.err.println("Whoops, got exception!");
            e.printStackTrace();
            System.err.println("thas was the exception!");
	}
    }

    public void testMe() throws Exception {
        HelloGL hg = new HelloGL();
        long nativeWindowPtr = _getNativeHandle();
        hg.testGLFromJava(nativeWindowPtr);
    }

    native long _getNativeHandle();

}
