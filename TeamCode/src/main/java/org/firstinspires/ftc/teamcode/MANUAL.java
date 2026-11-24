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

    MotorControl bench = new MotorControl();

    @Override
    public void init(){

        // drive controls
        bench.init2(hardwareMap);
    }

    @Override
    public void loop(){
        if (Math.abs(gamepad1.left_stick_y) > 0.1 || Math.abs(gamepad1.left_stick_x) > 0.1 || Math.abs(gamepad1.right_stick_x) > 0.1){
            bench.Motor(gamepad1.left_stick_y,gamepad1.left_stick_x, gamepad1.right_stick_x, gamepad1.circle);
        }
        else{
            bench.Motor(0,0, 0, false);
        }

    }

}
