package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;


import org.firstinspires.ftc.teamcode.lib.Robot;

@TeleOp(name = "MAIN TeleOp")
public class TheTeleOp extends LinearOpMode {
    private Robot robot;
    @Override
    public void runOpMode() {
        robot = new Robot(hardwareMap, telemetry);

        //telemetry.addData("Status", "Initialized");
        //telemetry.update();
        waitForStart();

        Gamepad drivingGamepad = gamepad1;
        Gamepad functionGamepad = gamepad2;

        while (opModeIsActive()){

            telemetry.addData("Motor Position:", "IDK!!");

            if(gamepad2.right_bumper) {
                drivingGamepad = gamepad2;
                functionGamepad = gamepad1;
                telemetry.addData("Driving gamepad: ", "Gamepad 2");
                telemetry.addData("Slide gamepad: ", "Gamepad 1");
            }
            if(gamepad1.right_bumper) {
                drivingGamepad = gamepad1;
                functionGamepad = gamepad2;
                telemetry.addData("Driving gamepad: ", "Gamepad 1");
                telemetry.addData("Slide gamepad: ", "Gamepad 2");

            }

            // DRIVING
            double x    =  drivingGamepad.left_stick_x;
            double y    = -drivingGamepad.left_stick_y;
            double turn =  drivingGamepad.right_stick_x;

            double theta = Math.atan2(y, x);
            double power = Math.hypot(x, y);

            robot.drive(theta, power, turn);

            DcMotor slideMotor = hardwareMap.get(DcMotor.class, "slide");
            slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            slideMotor.setPower(-functionGamepad.left_stick_y * .7);
            telemetry.addData("Motor Position", slideMotor.getCurrentPosition());

            telemetry.update();


            // OTHER FUNCTIONS



        }
    }
}
