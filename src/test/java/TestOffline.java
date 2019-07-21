import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@PowerMockIgnore({"com.package.IDataMapper", "com.package.ICache"})
@RunWith(PowerMockRunner.class)
@PrepareForTest({Parent.class})
public class TestOffline {

	@Test
	public void test() {
		try {
			Child mockChild = PowerMockito.mock(Child.class);
			PowerMockito.whenNew(Child.class).withNoArguments().thenReturn(mockChild);
			when(mockChild.getChildStatus()).thenReturn(false);
			Parent p = new Parent();
			boolean status = p.getStatus();
			assertTrue(status != true);
		} catch (Exception e) {
			fail();
		}
	}

}
