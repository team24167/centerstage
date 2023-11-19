package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.lib.MecanumDrivetrain;

@Autonomous(name = "Long Right Auto", group = "Autonomous")
public class LongAutoRight extends LinearOpMode {

    private MecanumDrivetrain drivetrain;

    @Override
    public void runOpMode() throws InterruptedException {

        drivetrain = new MecanumDrivetrain(this.hardwareMap, this.telemetry);

        waitForStart();
        drivetrain.turnRightForTime(0.5, 1200);
        drivetrain.driveForwardForTime(0.5, 5200);

    }
}
