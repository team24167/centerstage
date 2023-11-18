package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.lib.Robot;

@Autonomous(name = "autoleft", group = "Autonomous")
public class AutoLeft extends LinearOpMode {

//    private DcMotor frontLeft;
//    private DcMotor frontRight;
//    private DcMotor backLeft;
//    private DcMotor backRight;
//
//    private ElapsedTime runtime = new ElapsedTime();
    private Robot robot;

    @Override
    public void runOpMode() throws InterruptedException {
//        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
//        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
//        backLeft   = hardwareMap.get(DcMotor.class, "backLeft");
//        backRight  = hardwareMap.get(DcMotor.class, "backRight");
        // Init robot
        robot = new Robot(this.hardwareMap, this.telemetry);
        // Initialize motors

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        robot.turnLeftForTime(0.5, 10000); // Adjust speed and time as needed

        // Move forward for 5 seconds
        robot.driveForwardForTime(0.5, 5000); // Adjust speed and time as needed



        // Stop the robot
        robot.stopRobot();
    }

//    private void driveForwardForTime(double power, long time) {
//        frontLeft.setPower(power);
//        frontRight.setPower(power);
//        backLeft.setPower(power);
//        backRight.setPower(power);
//        sleep(time);
//    }
//
//    private void turnLeftForTime(double power, long time) {
//        frontLeft.setPower(-power);
//        frontRight.setPower(power);
//        backLeft.setPower(-power);
//        backRight.setPower(power);
//        sleep(time);
//    }
//
//    private void stopRobot() {
//        frontLeft.setPower(0);
//        frontRight.setPower(0);
//        backLeft.setPower(0);
//        backRight.setPower(0);
//    }
}
