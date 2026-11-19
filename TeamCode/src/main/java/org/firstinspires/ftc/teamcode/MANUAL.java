package org.firstinspires.ftc.teamcode;


import android.os.Build;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.teamcode.Mechanisms.MotorControl;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;


@TeleOp
public class MANUAL extends OpMode {

    public DcMotorEx flywheelMotor;
    double F = 11.4650;
    double P = 11.7830;

    int targetVelocity = 1000;
    int defualtVelocity = targetVelocity;
    int incrementDelay = 3;
    MotorControl bench = new MotorControl();

    Boolean flywheelOn = false;

    @Override
    public void init(){

        // drive controls
        bench.init2(hardwareMap);
        // flywheel
        flywheelMotor = hardwareMap.get(DcMotorEx.class, "Flywheel");
        flywheelMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheelMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P, 0, 0, F);
        flywheelMotor.setPIDFCoefficients(DcMotorEx.RunMode.RUN_USING_ENCODER, pidfCoefficients);
        telemetry.addLine("Init complete");
    }

    @Override
    public void loop(){
        if (Math.abs(gamepad1.left_stick_y) > 0.1 || Math.abs(gamepad1.left_stick_x) > 0.1 || Math.abs(gamepad1.right_stick_x) > 0.1){
            bench.Motor(gamepad1.left_stick_y,gamepad1.left_stick_x, gamepad1.right_stick_x, gamepad1.circle);
        }
        else{
            bench.Motor(0,0, 0, false);
        }
        if (gamepad1.right_trigger_pressed){
//            if (incrementDelay % 3 == 0){
//                targetVelocity++;
//            }
//            incrementDelay++;
            targetVelocity++;
        }
        else{
            if(targetVelocity > defualtVelocity){
                targetVelocity--;
            }
        }
        if(gamepad1.square){
            flywheelOn = true;
        }
        if(gamepad1.triangle){
            flywheelOn = false;
        }

        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P, 0, 0, F);
        flywheelMotor.setPIDFCoefficients(DcMotorEx.RunMode.RUN_USING_ENCODER, pidfCoefficients);
        // set velocity
        flywheelMotor.setVelocity(targetVelocity);

        double currentVelocity = flywheelMotor.getVelocity();
        double error = targetVelocity - currentVelocity;

        telemetry.addData("targetVelocity", targetVelocity);
        telemetry.addData("Current Velocity","%.2f",currentVelocity);
        telemetry.addData("Error (Abs)","%.2f",error);
        telemetry.addData("Tuning P","%.4f (DPad U/D)",P);
        telemetry.addData("Tuning F","%.4f (Dpad L/R)",F);


    }

}
