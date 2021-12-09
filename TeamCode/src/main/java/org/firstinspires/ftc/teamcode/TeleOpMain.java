package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;



@TeleOp(name="TeleOpFrieght1", group="Linear Opmode")
//@Disabled
public class TeleOpFrieght extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFront = null;
    private DcMotor rightFront = null;
    private DcMotor leftRear = null;
    private DcMotor rightRear = null;
    private DcMotor carouselMotor = null;
    private DcMotor armMotor = null;
    private Servo gripper = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        leftFront  = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        rightRear = hardwareMap.get(DcMotor.class, "rightRear");
        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");
        armMotor = hardwareMap.get(DcMotor.class, "armMotor");
        gripper = hardwareMap.get(Servo.class, "gripper");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        leftRear.setDirection(DcMotor.Direction.REVERSE);
        rightRear.setDirection(DcMotor.Direction.FORWARD);
        carouselMotor.setDirection(DcMotor.Direction.FORWARD);
        armMotor.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Setup a variable for each drive wheel to save power level for telemetry
            double leftPower;
            double rightPower;

            boolean carouselOn;

            // Choose to drive using either Tank Mode, or POV Mode
            // Comment out the method that's not used.  The default below is POV.

            // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0);
            rightPower   = Range.clip(drive - turn, -1.0, 1.0);
            boolean slowSpeed = gamepad1.left_bumper;
            boolean slowArm = gamepad2.left_bumper;

            boolean carousel = gamepad2.a;
            boolean carousel2 = gamepad2.b;
            
            double armMotorPower = gamepad2.left_stick_y;
            double gripperPosition = gamepad2.right_stick_x;


            armMotor.setPower(armMotorPower/1.5);
            gripper.setPosition(gripperPosition);

            // Send calculated power to wheels
            
            leftFront.setPower(leftPower);
            rightFront.setPower(rightPower);
            leftRear.setPower(leftPower);
            rightRear.setPower(rightPower);
            
            if (carousel) {
                carouselMotor.setPower(0.60);
                sleep(100);
                carouselMotor.setPower(0);

            }
            
            if (carousel2) {
                carouselMotor.setPower(-0.60);
                sleep(100);
                carouselMotor.setPower(0);

            }
           
           //Slow code it waiting for its return
            /*if (slowSpeed == true){

                leftFront.setPower(leftPower/4);
                rightFront.setPower(rightPower/4);
                leftRear.setPower(leftPower/4);
                rightRear.setPower(rightPower/4);
            
            }

            if (slowArm == true){

                armMotor.setPower(armMotorPower/4);

            }*/
            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();

            //turns on/off carousel motor
        }

    }
}
