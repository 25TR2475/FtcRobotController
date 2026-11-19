package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.MotorControl;



@TeleOp
public class MANUAL extends OpMode {

    int targetVelocity = 1000;
    int defualtVelocity = targetVelocity;
    MotorControl bench = new MotorControl();

    @Override
    public void init(){
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
        if (gamepad1.right_trigger_pressed){
            targetVelocity++;
        }
        else{
            if(targetVelocity > defualtVelocity){
                targetVelocity--;
            }
        }
        telemetry.addData("targetVelocity", targetVelocity);

    }

}
