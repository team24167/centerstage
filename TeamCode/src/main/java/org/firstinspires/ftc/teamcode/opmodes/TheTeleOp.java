package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


import org.firstinspires.ftc.teamcode.lib.MecanumDrivetrain;

@TeleOp(name = "MAIN TeleOp")
public class TheTeleOp extends LinearOpMode {
    private MecanumDrivetrain drivetrain;
    private DcMotor intakeMotor;
    @Override
    public void runOpMode() {
        drivetrain = new MecanumDrivetrain(hardwareMap, telemetry);
        intakeMotor = hardwareMap.get(DcMotor.class, "ils");

        waitForStart();

        while (opModeIsActive()){

            double power = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            if (gamepad2.x) {
                intakeMotor.setPower(0.5);
            } else {
                intakeMotor.setPower(0);
            }

            drivetrain.drive(power, strafe, turn);

            telemetry.update();


        }
    }
}
