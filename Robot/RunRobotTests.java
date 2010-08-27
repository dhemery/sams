

import org.robotframework.RobotFramework;

public class RunRobotTests {

	public static void main(String[] args) {
		RobotFramework.run(new String[] { "-C", "off", "-d", "RobotResults", "RobotTests" });
	}

}
