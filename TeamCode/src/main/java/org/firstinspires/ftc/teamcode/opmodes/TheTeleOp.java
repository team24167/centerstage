package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.teamcode.lib.Robot;

@TeleOp(name = "tele is the opp")
public class TheTeleOp extends LinearOpMode {

    private Robot robot = new Robot(hardwareMap, telemetry);
    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("Status", "Running!!!!");
            telemetry.update();

            robot.drive(-this.gamepad1.left_stick_y);

        }

    }
}
