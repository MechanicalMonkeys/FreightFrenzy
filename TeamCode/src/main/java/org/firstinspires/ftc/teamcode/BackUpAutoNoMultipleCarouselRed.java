package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Disabled
@Autonomous(name = "BackUpRedSideAutonoumous")
public class BackUpAutoNoMultipleCarouselRed extends LinearOpMode {

    private DcMotor leftFront;
    private DcMotor leftRear;
    private DcMotor rightFront;
    private DcMotor rightRear;
    private DcMotor carouselMotor;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightRear = hardwareMap.get(DcMotor.class, "rightRear");
        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");

        // Inizilization
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();


        movement(0.5,500);

        rightTurn(0.5,500);

        movement(-0.5,500);

        carousel(0.1,1000);

        movement(0.5,500);

        //Parking in warehouse

        rightTurn(0.5,500);

        movement(1,1500);

    }

    //Methods

    //Move Straight
    public void movement(double speed, int waitMS) {

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
}