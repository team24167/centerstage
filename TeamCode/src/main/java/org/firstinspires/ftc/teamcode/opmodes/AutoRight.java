package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.lib.MecanumDrivetrain;

@Autonomous(name = "Short Right Auto", group = "Autonomous")
public class AutoRight extends LinearOpMode {

    private MecanumDrivetrain drivetrain;

    @Override
    public void runOpMode() throws InterruptedException {
        drivetrain = new MecanumDrivetrain(this.hardwareMap, this.telemetry);

        waitForStart();
        drivetrain.turnRightForTime(0.5, 1200); // Adjust speed and time as needed
        drivetrain.driveForwardForTime(0.5, 2550); // Adjust speed and time as needed

    }

}
