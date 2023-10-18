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
            double x    =  gamepad1.left_stick_x;
            double y    = -gamepad1.left_stick_y;
            double turn =  gamepad1.right_stick_x;

            double theta = Math.atan2(y, x);
            double power = Math.hypot(x, y);


            robot.drive(theta, power, turn);

        }

    }
}
