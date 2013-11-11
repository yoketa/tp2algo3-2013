package fiuba.algo3.gpschallenge;

import junit.framework.Assert;
import org.junit.Test;

import fiuba.algo3.gpschallenge.modelo.Foo;

public class FooTest {

	@Test
	public void doFooShouldReturnFoo(){
        Foo foo = new Foo();
        String result = foo.doFoo();
        Assert.assertEquals("Fooa", result);

	}

}
