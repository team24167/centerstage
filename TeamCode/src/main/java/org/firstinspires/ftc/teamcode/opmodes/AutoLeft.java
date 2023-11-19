package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.lib.MecanumDrivetrain;

@Autonomous(name = "Short Left Auto", group = "Autonomous")
public class AutoLeft extends LinearOpMode {

    private MecanumDrivetrain drivetrain;

    @Override
    public void runOpMode() throws InterruptedException {
        drivetrain = new MecanumDrivetrain(this.hardwareMap, this.telemetry);
        waitForStart();

        drivetrain.turnLeftForTime(0.5, 1200); // Adjust speed and time as needed

        // Move forward for 5 seconds
        drivetrain.driveForwardForTime(0.5, 2550); // Adjust speed and time as needed



        // Stop the robot
    }

}
