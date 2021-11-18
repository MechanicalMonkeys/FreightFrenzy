package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "AutonomousRedSide")
public class AutonomousRedSide extends LinearOpMode {

    private DcMotor leftFront;
    private DcMotor leftRear;
    private DcMotor rightFront;
    private DcMotor rightRear;
    private DcMotor carouselMotor;
    private DcMotor armMotor;

    //@Disabled
    @Override
    public void runOpMode() {
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightRear = hardwareMap.get(DcMotor.class, "rightRear");
        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");
        armMotor = hardwareMap.get(DcMotor.class, "armMotor");

        // Inizilization
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();

        //moves out
        movementStraight(0.5,1000);

        //turns so the wheel is facing carousel
        rightTurn(1,500);

        //slow movement so it dosnt move wierd when changing direction
        movementStraight(-0.1,300);

        //moves toward carousel
        movementStraight(-0.5,1500);

        //spins carousel
        carousel(.45,2000);

        //moves away from carousel
        movementStraight(0.5,1600);

        //sleeps so no wierd movements
        sleep(500);

        for (int i = 0; i < 2; i++){

            //slight turn to fix robot slightly turning
            rightTurn(0.25,150);

            //slow movement so it dosnt move wierd when changing direction
            movementStraight(-0.1,300);

            //moves toward carousel
            movementStraight(-0.5,1500);

            //spins carousel
            carousel(.45,2250);

            //moves away from carousel
            movementStraight(0.5,1600);

            //sleeps so no wierd movements
            sleep(500);

        }

        //Parking in warehouse optional

        rightTurn(0.5,575);

        //moves arm up so it dosn't hit anything

        armMove(1,500);

        movementStraight(1,2500);

    }

    //Methods

    //Move Straight
    public void movementStraight(double speed, int waitMS) {

        //moving
        leftFront.setPower(speed);
        rightFront.setPower(speed);
        leftRear.setPower(speed);
        rightRear.setPower(speed);

        //waiting
        sleep(waitMS);

        //stopping
        leftFront.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
        leftRear.setPower(0);

    }

    //Left Turn
    public void leftTurn(double speed, int waitMS) {

        //LeftTurn
        leftFront.setPower(-speed);
        rightFront.setPower(speed);
        leftRear.setPower(-speed);
        rightRear.setPower(speed);

        //waiting
        sleep(waitMS);

        //stopping
        leftFront.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
        leftRear.setPower(0);

    }

    //RightTurn
    public void rightTurn(double speed, int waitMS) {

        //RightTurn
        leftFront.setPower(speed);
        rightFront.setPower(-speed);
        leftRear.setPower(speed);
        rightRear.setPower(-speed);

        //waiting
        sleep(waitMS);

        //stopping
        leftFront.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
        leftRear.setPower(0);

    }

    //Carousel Movement
    public void carousel(double speed, int waitMS) {

        //Spin Carousel
        carouselMotor.setPower(speed);

        //waiting
        sleep(waitMS);

        //stopping
        carouselMotor.setPower(0);


    }

    //Arm Movement
    public void armMove(double speed, int waitMS) {

        //Move arm up
        armMotor.setPower(speed);

        //waiting
        sleep(waitMS);

        //No stopping the pain
        //armMotor.setPower(0);


    }
}
