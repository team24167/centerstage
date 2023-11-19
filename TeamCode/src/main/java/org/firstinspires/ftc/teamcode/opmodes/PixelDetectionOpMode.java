import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

@Autonomous(name = "PixelPlacementAutonomous", group = "Autonomous")
public class PixelDetectionOpMode extends LinearOpMode {

    private ColorSensor colorSensor;

    @Override
    public void runOpMode() {
        // Initialize color sensor
        colorSensor = hardwareMap.get(ColorSensor.class, "color_sensor");

        // Wait for the start button to be pressed
        waitForStart();

        // Main autonomous loop
        while (opModeIsActive()) {
            // Detect the location of the first pixel
            Location pixelLocation = detectPixelLocation();

            // Move the robot to pick up another pixel based on the detected location
            moveRobotToPickupPixel(pixelLocation);

            // Place the picked-up pixel on the board
            placePixelOnBoard(pixelLocation);

            // End the autonomous loop
            break;
        }
    }

    // Enum to represent possible pixel locations
    private enum Location {
        LEFT,
        RIGHT,
        CENTER
    }

    // Detect the location of a colored pixel
    private Location detectPixelLocation() {
        // Capture image from color sensor
        Mat image = getColorSensorImage();

        // Process the captured image for color detection
        Location detectedLocation = processImageForLocation(image);

        // Log the detected location (for debugging purposes)
        telemetry.addData("Detected Location", detectedLocation);
        telemetry.update();

        return detectedLocation;
    }

    // Move the robot to pick up another pixel based on the detected location
    private void moveRobotToPickupPixel(Location pixelLocation) {
        // Implement logic to move the robot to pick up another pixel based on the detected location
        // For example, if the pixel is on the left, turn left; if on the right, turn right; if in the center, move forward.
    }

    // Place the picked-up pixel on the board based on the detected location
    private void placePixelOnBoard(Location pixelLocation) {
        // Implement logic to place the picked-up pixel on the board based on the detected location
        // For example, if the pixel was on the left, place it on the left side of the board; if on the right, place it on the right side; if in the center, place it in the center.
    }

    // Capture image from the color sensor
    private Mat getColorSensorImage() {
        Mat image = new Mat();
        int red = colorSensor.red();
        int green = colorSensor.green();
        int blue = colorSensor.blue();

        // Create an image matrix with a single pixel representing the detected color
        image.put(0, 0, blue, green, red);

        return image;
    }

    // Process the image to detect the location of a colored pixel
    private Location processImageForLocation(Mat image) {
        // Convert image to HSV color space
        Imgproc.cvtColor(image, image, Imgproc.COLOR_BGR2HSV);

        // Define color ranges for left, right, and center (adjust these based on your specific colors)
        Scalar leftBound = new Scalar(30, 50, 50);
        Scalar leftUpperBound = new Scalar(60, 255, 255);
        Scalar rightBound = new Scalar(90, 50, 50);
        Scalar rightUpperBound = new Scalar(120, 255, 255);
        Scalar centerBound = new Scalar(150, 50, 50);
        Scalar centerUpperBound = new Scalar(180, 255, 255);

        // Threshold the image to isolate colors within the specified ranges
        Mat leftMask = new Mat();
        Mat rightMask = new Mat();
        Mat centerMask = new Mat();

        Core.inRange(image, leftBound, leftUpperBound, leftMask);
        Core.inRange(image, rightBound, rightUpperBound, rightMask);
        Core.inRange(image, centerBound, centerUpperBound, centerMask);

        // Count non-zero pixels in each mask
        int leftPixelCount = Core.countNonZero(leftMask);
        int rightPixelCount = Core.countNonZero(rightMask);
        int centerPixelCount = Core.countNonZero(centerMask);

        // Determine the location based on pixel counts
        if (leftPixelCount > rightPixelCount && leftPixelCount > centerPixelCount) {
            return Location.LEFT;
        } else if (rightPixelCount > leftPixelCount && rightPixelCount > centerPixelCount) {
            return Location.RIGHT;
        } else {
            return Location.CENTER;
        }
    }
}
