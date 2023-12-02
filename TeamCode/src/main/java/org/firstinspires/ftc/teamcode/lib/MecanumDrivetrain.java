package org.firstinspires.ftc.teamcode.lib;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MecanumDrivetrain {
    private final double frontRightScaleFactor = 1.00;
    private final double frontLeftScaleFactor = 1.00;
    private final double backLeftScaleFactor = 0.9;
    private final double backRightScaleFactor = 0.9;

    // Stuff from the op mode
    private HardwareMap hardwareMap;
    private Telemetry telemetry;

    // Hardware
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor backRight;



    public MecanumDrivetrain(HardwareMap hwm, Telemetry t) {
        this.hardwareMap = hwm;
        this.telemetry = t;

        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft   = hardwareMap.get(DcMotor.class, "backLeft");
        backRight  = hardwareMap.get(DcMotor.class, "backRight");
    }

    public void drive(double power, double strafe, double turn) {


        telemetry.addData("Power: ", power);
        telemetry.addData("Turn: ", turn);
        telemetry.addData("Strafe: ", strafe);

        double denominator = Math.max(Math.abs(power) + Math.abs(strafe) + Math.abs(turn), 1);

        double frontLeftPow = (power + strafe + turn) / denominator;
        double backLeftPow = (power - strafe + turn) / denominator;
        double frontRightPow = (power - strafe - turn) / denominator;
        double backRightPow = (power + strafe - turn) / denominator;

        telemetry.addData("CALC Front Left Power", frontLeftPow);
        telemetry.addData("CALC Front Right Power", frontRightPow);
        telemetry.addData("CALC Back Left Power", backLeftPow);
        telemetry.addData("CALC Back Right Power", backRightPow);



        frontLeft.setPower(frontLeftPow * frontLeftScaleFactor);
        frontRight.setPower(frontRightPow * frontRightScaleFactor * -1);
        backLeft.setPower(backLeftPow * backLeftScaleFactor);
        backRight.setPower(backRightPow * backRightScaleFactor * -1);

        telemetry.addData("TRUE Front Left Power", frontLeft.getPower());
        telemetry.addData("TRUE Front Right Power", frontRight.getPower());
        telemetry.addData("TRUE Back Left Power", backLeft.getPower());
        telemetry.addData("TRUE Back Right Power", backRight.getPower());

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


    public void runIndividualMotor(int num){
        switch(num){
            case 0:
                frontLeft.setPower(1);
                break;
            case 1:
                frontRight.setPower(1);
                break;
            case 2:
                backLeft.setPower(1);
                break;
            case 3:
                backRight.setPower(1);
                break;
        }
        telemetry.addData("Front Left Power", frontLeft.getPower());
        telemetry.addData("Front Right Power", frontRight.getPower());
        telemetry.addData("Back Left Power", backLeft.getPower());
        telemetry.addData("Back Right Power", backRight.getPower());
        telemetry.update();
    }

}
