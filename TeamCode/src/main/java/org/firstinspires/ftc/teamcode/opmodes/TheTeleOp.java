package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.teamcode.lib.MecanumDrivetrain;

@TeleOp(name = "MAIN TeleOp")
public class TheTeleOp extends LinearOpMode {
    private MecanumDrivetrain drivetrain;
    @Override
    public void runOpMode() {
        drivetrain = new MecanumDrivetrain(hardwareMap, telemetry);

        waitForStart();

        while (opModeIsActive()){

            double power = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x * 1.1;
            double turn = gamepad1.right_stick_x;

            drivetrain.drive(power, strafe, turn);

            telemetry.update();


        }
    }
}
