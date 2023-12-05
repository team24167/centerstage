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

        // Tuning instructions:
        // Change the ms (second) value in drivetrain.turnLeftForTime/driveForwardForTime to
        // the correct value
        // To add a delay, remove the two slashes before the line "Thread.sleep(a number here)",
        // and change the 1000 to whatever time it needs to sleep for

        drivetrain.turnRightForTime(0.5, 1200);
        // Thread.sleep(1000)
        drivetrain.driveForwardForTime(0.5, 5200);

    }
}
