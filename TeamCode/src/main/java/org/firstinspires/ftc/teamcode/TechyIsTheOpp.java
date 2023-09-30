package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class TechyIsTheOpp extends LinearOpMode {
    private DcMotor mm;
    private Servo sv;

    @Override
    public void runOpMode() {
        mm = hardwareMap.get(DcMotor.class, "mm");
        sv = hardwareMap.get(Servo.class, "sv");


        telemetry.addData("hi", "varun (initialized)");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("hi", "techy (running)");
            telemetry.update();

            mm.setPower(-this.gamepad1.left_stick_y);
            telemetry.addData("power", mm.getPower());

            sv.scaleRange(0.25, 0.75);

            sv.setPosition(-this.gamepad1.right_stick_y);
            telemetry.addData("servo pos", sv.getPosition());



        }

    }
}
