package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;


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
            //telemetry.addData("Status", "Running!!!!") ;

            Gamepad activeGamepad = gamepad1;

            if(gamepad2.right_bumper)
                activeGamepad = gamepad2;
            if(gamepad1.right_bumper)
                activeGamepad = gamepad1;

            double x    =  activeGamepad.left_stick_x;
            double y    = -activeGamepad.left_stick_y;
            double turn =  activeGamepad.right_stick_x;

            double theta = Math.atan2(y, x);
            double power = Math.hypot(x, y);

            robot.drive(theta, power, turn);

            /*
            if(gamepad2.circle) robot.runIndividualMotor(3);
            if(gamepad2.square) robot.runIndividualMotor(0);
            if(gamepad2.cross) robot.runIndividualMotor(2);
            if(gamepad2.triangle) robot.runIndividualMotor(1);
            */

        }
    }
}
