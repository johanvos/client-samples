package hello;

public class HelloWorld {

    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        hw.testMe();
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
        System.exit(0);
    }

    native long _getNativeHandle();

}
