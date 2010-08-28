package com.samscdrental.robot;


import org.robotframework.RobotFramework;

public class RunTests {

	public static void main(String[] args) {
		RobotFramework.run(new String[] { "-C", "off", "-d", "RobotResults", "RobotTests" });
	}

}
