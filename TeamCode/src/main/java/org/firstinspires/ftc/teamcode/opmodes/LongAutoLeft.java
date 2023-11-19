package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.lib.MecanumDrivetrain;

@Autonomous(name = "Long Left Auto", group = "Autonomous")
public class LongAutoLeft extends LinearOpMode {

    private MecanumDrivetrain drivetrain;

    @Override
    public void runOpMode() throws InterruptedException {

        drivetrain = new MecanumDrivetrain(this.hardwareMap, this.telemetry);
        waitForStart();
        drivetrain.turnLeftForTime(0.5, 1200);

        // Move forward for 5 seconds
        drivetrain.driveForwardForTime(0.5, 5200);

    }

}