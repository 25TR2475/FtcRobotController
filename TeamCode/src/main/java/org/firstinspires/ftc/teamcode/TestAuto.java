package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Mechanisms.MotorTest;
@TeleOp
public class TestAuto extends OpMode {
    ElapsedTime timer = new ElapsedTime();
    MotorTest bench = new MotorTest();

    double forwConst = 1;
    double backConst = 0.8;
    double strafeConst = 1;
    double spinConst = 0.4;
    int Ycount = 0;
    int Xcount = 0;
    int Rcount = 0;

    public void init(){
    }

    public void loop() {
        bench.init2(hardwareMap);
        if (gamepad1.dpadUpWasPressed()){
            Ycount++;
        }
        if (gamepad1.dpadDownWasPressed()){
            Ycount--;
        }
        if (gamepad1.dpadRightWasPressed()){
            Xcount++;
        }
        if (gamepad1.dpadLeftWasPressed()){
            Xcount--;
        }
        if (gamepad1.rightBumperWasPressed()){
            Rcount++;
        }
        if (gamepad1.leftBumperWasPressed()){
            Rcount--;
        }
        telemetry.addData("Y-Movement", Ycount);
        telemetry.addData("X-Movement", Xcount);
        telemetry.addData("Rotation", Rcount);

        if (gamepad1.xWasPressed()){
            if (Ycount > 0){
                timer.startTime();
                while (timer.time() < Ycount * forwConst){
                    bench.Motor(1,0,0,false);
                }
            }
            if (Ycount < 0){
                timer.startTime();
                while (timer.time() < Ycount * backConst){
                    bench.Motor(-1,0,0,false);
                }
            }
            bench.Motor(0,0,0,false);
            if (Xcount > 0){
                timer.startTime();
                while (timer.time() < Xcount * strafeConst){
                    bench.Motor(0,1,0,false);
                }
            }
            if (Xcount < 0){
                timer.startTime();
                while (timer.time() < Xcount * strafeConst){
                    bench.Motor(0,-1,0,false);
                }
            }
            bench.Motor(0,0,0,false);
            if (Rcount > 0){
                timer.startTime();
                while (timer.time() < Rcount * spinConst){
                    bench.Motor(0,0,1,false);
                }
            }
            if (Rcount < 0){
                timer.startTime();
                while (timer.time() < Rcount * spinConst){
                    bench.Motor(0,0,-1,false);
                }
            }
            bench.Motor(0,0,0,false);
        }
        bench.Motor(0,0,0,false);
    }
}
