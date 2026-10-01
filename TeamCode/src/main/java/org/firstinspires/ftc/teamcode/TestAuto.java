package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Mechanisms.MotorTest;
@Autonomous
public class TestAuto extends OpMode {
    ElapsedTime timer = new ElapsedTime();
    MotorTest bench = new MotorTest();

    public void init(){
        bench.init2(hardwareMap);
        int count = 0;
        while (gamepad1.left_trigger_pressed == false){
            if (gamepad1.dpad_up){
                count++;
            }
            if (gamepad1.dpad_down){
                count--;
            }
            telemetry.addData("Amount", count);
        }
        timer.startTime();
        while (timer.time() < count){
            bench.Motor(-1,0,0,false);
        }
        bench.Motor(0,0,0,false);
    }

    public void loop() { }
}
