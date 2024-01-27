package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


import org.firstinspires.ftc.teamcode.lib.MecanumDrivetrain;

@TeleOp(name = "MAIN TeleOp")
public class TheTeleOp extends LinearOpMode {
    private MecanumDrivetrain drivetrain;
    private DcMotor intakeMotor, slideMotorLeft, slideMotorRight;

    private Servo slideServo, outTakeServo, pixelServo;
    @Override
    public void runOpMode() {
        drivetrain = new MecanumDrivetrain(hardwareMap, telemetry);
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        slideMotorLeft = hardwareMap.get(DcMotor.class, "slideMotorLeft");
        slideMotorRight = hardwareMap.get(DcMotor.class, "slideMotorRight");


        slideServo = hardwareMap.get(Servo.class, "slideServo");
        outTakeServo = hardwareMap.get(Servo.class, "outTakeServo");
        pixelServo = hardwareMap.get(Servo.class, "pixelServo");

        waitForStart();

        while (opModeIsActive()){

            double power = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            if (gamepad2.cross) {
                intakeMotor.setPower(0.5);
            } else if (gamepad2.triangle) {
                intakeMotor.setPower(-0.5);
            } else {
                intakeMotor.setPower(0);
            }

            double slidePow = -gamepad2.left_stick_y;

            slideMotorLeft.setPower(slidePow);
            slideMotorRight.setPower(slidePow);


            if (gamepad2.dpad_down) {
                // engage

                double slidePos = 0.0;
                double outTakePos = 0.0;
                double pixelPos = 0.0;

                slideServo.setPosition(slidePos);
                outTakeServo.setPosition(outTakePos);
                pixelServo.setPosition(pixelPos);
            } else if (gamepad2.dpad_up) {
                // return to neutral
                double slidePos = 0.0;
                double outTakePos = 0.0;
                double pixelPos = 0.0;

                slideServo.setPosition(slidePos);
                outTakeServo.setPosition(outTakePos);
                pixelServo.setPosition(pixelPos);
            }

            drivetrain.drive(power, strafe, turn);

            telemetry.update();


        }
    }
}
