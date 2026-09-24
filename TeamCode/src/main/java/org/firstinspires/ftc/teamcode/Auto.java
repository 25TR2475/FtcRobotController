package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Mechanisms.MotorTest;
@Autonomous
public class Auto extends OpMode {
    ElapsedTime timer = new ElapsedTime();
    MotorTest bench = new MotorTest();

    public void init(){
        bench.init2(hardwareMap);
        timer.startTime();
        while (timer.time() < 1){
            bench.Motor(1,0,0,false);
        }
        while (timer.time() < 2){
            bench.Motor(0,1,0,false);
        }
        while (timer.time() < 3){
            bench.Motor(-1,0,0,false);
        }
        while (timer.time() < 4){
            bench.Motor(0,-1,0,false);
        }
        while (timer.time() < 5){
            bench.Motor(0,0,1,false);
        }
    }

    public void loop() { }
}
