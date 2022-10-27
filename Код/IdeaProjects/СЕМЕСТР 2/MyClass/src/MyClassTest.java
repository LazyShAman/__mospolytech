import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class MyClassTest {
    int i;

    @Ignore
    @Test(timeout = 1000)
    public void testMin() {
        f();
        int min = MyClass.min(3, 5, 4);
        if (min != 3) {
            fail("QQQ");
        }
        assertEquals(3, MyClass.min(3, 5, 4));
    }

    @Test
    public void testConstructor() {
        f();
        MyClass c = new MyClass(100);
        assertEquals(100, c.getAttr());
    }

    @Test
    public void testDiv() {
        f();
        MyClass c = new MyClass(100);
        assertEquals(10, c.div(10));
        try {
            c.div(0);
        } catch (Exception e) {
        }
    }

    @Test
    public void testDiv2() {
        f();
        assertEquals(10, new MyClass(100).div(10));

    }

    public void f() {
        i = -1;
        System.out.println("!");
    }
}