package org.firstinspires.ftc.teamcode.lib;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

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

        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft   = hardwareMap.get(DcMotor.class, "backLeft");
        backRight  = hardwareMap.get(DcMotor.class, "backRight");
    }

    public void drive(double pow) {
        frontRight.setPower(pow);
        telemetry.addData("Front Right Power", frontRight.getPower());
        telemetry.update();

        frontLeft.setPower(pow);
        telemetry.addData("Front Left Power", frontLeft.getPower());
        telemetry.update();

        backRight.setPower(pow);
        telemetry.addData("Back Right Power", backRight.getPower());
        telemetry.update();

        backLeft.setPower(pow);
        telemetry.addData("Back Left Power", backRight.getPower());
    }


}
