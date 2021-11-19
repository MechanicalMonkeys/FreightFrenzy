package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "RedFarAuto")
public class RedFarAuto extends LinearOpMode {

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

        movementStraight(0.5, 750);

        armMove(1, 100);

        rightTurn(1, 600);

        movementStraight(1, 1250);


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
