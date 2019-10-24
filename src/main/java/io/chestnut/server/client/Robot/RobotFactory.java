package io.chestnut.server.client.Robot;

import io.chestnut.server.client.Robot.component.TestComponet;

public class RobotFactory {
	public static Robot newRobot(String playerId) {
		Robot Robot = new Robot(playerId);
		Robot.addComponent(new TestComponet());
		return Robot;
	}
}
