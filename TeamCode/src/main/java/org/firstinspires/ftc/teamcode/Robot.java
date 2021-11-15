package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.hardware.kauailabs.NavxMicroNavigationSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IntegratingGyroscope;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

// THIS IS NOT AN OPMODE - IT IS A DEFINING CLASS
public class Robot {
    // Motors
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFront = null;
    private DcMotor rightFront = null;
    private DcMotor leftRear = null;
    private DcMotor rightRear = null;
    private DcMotor carouselMotor = null;
    private DcMotor armMotor = null;
    private Servo gripper = null;

    enum armPosition {REST, ACTIVE}
    armPosition armPos = armPosition.REST;
    Orientation angles;

    private HardwareMap hwMap;

    public Robot (OpMode opmode) {
        // Constructor
        /* Initializes the robot */
        hwMap = opmode.hardwareMap;

        // Motor mapping
        leftFront  = hwMap.get(DcMotor.class, "leftFront");
        rightFront = hwMap.get(DcMotor.class, "rightFront");
        leftRear = hwMap.get(DcMotor.class, "leftRear");
        rightRear = hwMap.get(DcMotor.class, "rightRear");
        carouselMotor = hwMap.get(DcMotor.class, "carouselMotor");
        armMotor = hwMap.get(DcMotor.class, "armMotor");
        gripper = hwMap.get(Servo.class, "gripper");

        // Drive Motor Direction
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        leftRear.setDirection(DcMotor.Direction.REVERSE);
        rightRear.setDirection(DcMotor.Direction.FORWARD);
        carouselMotor.setDirection(DcMotor.Direction.FORWARD);
        armMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    void setDrivePower(double leftPower,double rightPower) {
        leftFront.setPower(leftPower);
        rightFront.setPower(rightPower);
        leftRear.setPower(leftPower);
        rightRear.setPower(rightPower);
    }

    void setGripperPosition(double position){

        gripper.setPosition(position);

    }

    void setCarouselPower(double power){

        carouselMotor.setPower(power);

    }

    void setArmPower(double power){

        armMotor.setPower(power);

    }
}

