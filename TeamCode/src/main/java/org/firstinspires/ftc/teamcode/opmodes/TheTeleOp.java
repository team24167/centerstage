package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.teamcode.lib.Robot;

@TeleOp(name = "tele is the opp")
public class TheTeleOp extends LinearOpMode {
    private Robot robot;
    @Override
    public void runOpMode() {
        robot = new Robot(hardwareMap, telemetry);

        //telemetry.addData("Status", "Initialized");
        //telemetry.update();
        waitForStart();

        while (opModeIsActive()){
            //telemetry.addData("Status", "Running!!!!");
            double x    =  gamepad2.left_stick_x;
            double y    = -gamepad2.left_stick_y;
            double turn =  gamepad2.right_stick_x;

            double theta = Math.atan2(y, x);
            double power = Math.hypot(x, y);

            robot.drive(theta, power, turn);

            if(gamepad2.circle) robot.runIndividualMotor(3);
            if(gamepad2.square) robot.runIndividualMotor(0);
            if(gamepad2.cross) robot.runIndividualMotor(2);
            if(gamepad2.triangle) robot.runIndividualMotor(1);


        }

    }
}
