package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.MotorTest;


@TeleOp
public class DcMotorTest extends OpMode {

    MotorTest bench = new MotorTest();

    @Override
    public void init(){
        bench.init2(hardwareMap);
    }

    @Override
    public void loop(){
        if (Math.abs(gamepad1.left_stick_y) > 0.2){
            bench.motorSpeed(-gamepad1.left_stick_y);
        }
    }
}
