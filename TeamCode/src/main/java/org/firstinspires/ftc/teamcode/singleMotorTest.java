package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.MotorControl;

@TeleOp
public class singleMotorTest extends OpMode {

    MotorControl bench = new MotorControl();

    @Override
    public void init(){
        bench.init2(hardwareMap);
    }

    @Override
    public void loop(){
        if(gamepad1.circle){
            bench.Motor(1, 0, 0, false);
        }

    }
}
