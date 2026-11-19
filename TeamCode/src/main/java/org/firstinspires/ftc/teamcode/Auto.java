package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Mechanisms.MotorControl;
@Autonomous
public class Auto extends OpMode {
    ElapsedTime timer = new ElapsedTime();
    MotorControl bench = new MotorControl();

    public void init(){
        bench.init2(hardwareMap);
        timer.startTime();
        while (timer.time() < 2){
            bench.Motor(-1,0,0,false);
        }
        while (timer.time() < 4){
            bench.Motor(0,1,0,false);
        }
        while (timer.time() < 6){
            bench.Motor(1,0,0,false);
        }
        while (timer.time() < 8){
            bench.Motor(0,-1,0,false);
        }
        while (timer.time() < 9.2){
            bench.Motor(0,0,1,false);
        }
        while (timer.time() < 10.4){
            bench.Motor(0,0,-1,false);
        }
        while (timer.time() < 11) {
            bench.Motor(0,0,0,false);
        }
        while (11 < timer.time() && timer.time() < 13){
            bench.Motor(-1,0,0,false);
        }
        bench.Motor(0,0,0,false);
    }

    public void loop() { }
}
