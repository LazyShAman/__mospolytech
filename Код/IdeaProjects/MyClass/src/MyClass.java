import org.junit.Test;

import static org.junit.Assert.*;

class MyClass {
    int i;
    @Test(timeout = 1000)
    public void testMin() {
        f();
        int min = MyClassTest.min(3, 5, 4);
        if (min != 3) fail("ooo");
        assertEquals(3, MyClassTest.min(3, 5, 4));
        //while (true) { }
    }

    @Test
    public void testConstructor() {
        f();
        MyClassTest c = new MyClassTest(100);
        assertEquals(100, c.getAttr());
    }

    @Test
    public void testDiv() {
        f();
        MyClassTest c = new MyClassTest(100);
        assertEquals(10, c.div(10));
        try {
            c.div(0);
        } catch (Exception e) {;}
    }

    @Test (expected = Exception.class)
    public void testDiv2() {
        f();
        new MyClassTest(100).div(10);

    }

    public void f() {
        i = -1;
        System.out.println("!");
    }
}