import static org.junit.Assert.*;

import org.junit.Test;


public class DashBoardTest {

	@Test
	public void testConstructor() {
		DashBoard db = new DashBoard(null);
		assertNull(db.getTaskList());
	}

}
