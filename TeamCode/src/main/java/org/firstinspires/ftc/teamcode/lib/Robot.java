package org.firstinspires.ftc.teamcode.lib;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {
    // Stuff from the op mode
    private HardwareMap hardwareMap;
    private Telemetry telemetry;

    // Hardware
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor backRight;


    public Robot(HardwareMap hwm, Telemetry t) {
        this.hardwareMap = hwm;
        this.telemetry = t;

        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft   = hardwareMap.get(DcMotor.class, "backLeft");
        backRight  = hardwareMap.get(DcMotor.class, "backRight");
    }

    public void drive(double theta, double power, double turn) {
        double sin = Math.sin(theta - Math.PI/4);
        double cos = Math.cos(theta - Math.PI/4);
        double max = Math.max(Math.abs(sin), Math.abs(cos));

        double frontLeftPow = power * cos/max + turn;
        double frontRightPow = power * sin/max - turn;
        double backLeftPow = power * sin/max + turn;
        double backRightPow = power * cos/max - turn;

        if ((power + Math.abs(turn)) > 1) {
            frontLeftPow /= power + turn;
            frontRightPow /= power + turn;
            backLeftPow /= power + turn;
            backRightPow /= power + turn;
        }

//        frontLeftPow *= -1;
//        backLeftPow *= -1;

        telemetry.addData("Theta: ", theta);
        telemetry.addData("power: ", power);
        telemetry.addData("turn: ", turn);

        telemetry.addData("Front Left Power", frontLeftPow);
        telemetry.addData("Front Right Power", frontRightPow);
        telemetry.addData("Back Left Power", backLeftPow);
        telemetry.addData("Back Right Power", backRightPow);
        telemetry.update();


        frontLeft.setPower(frontLeftPow);
        frontRight.setPower(frontRightPow);
        backLeft.setPower(backLeftPow * 0.8f);
        backRight.setPower(backRightPow * 0.8f);
    }

    public void turnLeftForTime(double power, long ms) throws InterruptedException {
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        frontLeft.setPower(-power);
        frontRight.setPower(power);
        backLeft.setPower(-power * 0.8f);
        backRight.setPower(power * 0.8f);
        Thread.sleep(ms);

        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);

    }

    public void turnRightForTime(double power, long ms) throws InterruptedException {

        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(power);
        backRight.setPower(-power);

        Thread.sleep(ms);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);

    }

    public void driveBackwardForTime(double power, long time) throws InterruptedException {
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        frontRight.setPower(-power);
        frontLeft.setPower(-power);
        backLeft.setPower(-power);
        backRight.setPower(-power);

        Thread.sleep(time);

        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);

    }

    public void driveForwardForTime(double power, long time) throws InterruptedException {
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power * 0.8f);
        backRight.setPower(power * 0.8f);
        Thread.sleep(time);

        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);


    }

    public void stopRobot() {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }


//    public void runIndividualMotor(int num){
//        switch(num){
//            case 0:
//                frontLeft.setPower(1);
//                break;
//            case 1:
//                frontRight.setPower(1);
//                break;
//            case 2:
//                backLeft.setPower(1);
//                break;
//            case 3:
//                backRight.setPower(1);
//                break;
//        }
//        telemetry.addData("Front Left Power", frontLeft.getPower());
//        telemetry.addData("Front Right Power", frontRight.getPower());
//        telemetry.addData("Back Left Power", backLeft.getPower());
//        telemetry.addData("Back Right Power", backRight.getPower());
//        telemetry.update();
//    }

}
