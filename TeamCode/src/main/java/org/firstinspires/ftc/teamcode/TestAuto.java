package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Mechanisms.MotorTest;

import java.util.Arrays;

@TeleOp
public class TestAuto extends OpMode {
    ElapsedTime timer = new ElapsedTime();
    MotorTest bench = new MotorTest();

    double forwConst = 1;
    double backConst = 0.8;
    double strafeConst = 1;
    double spinConst = 0.4;


    int[] variables = new int[3];
    int maxVar = 0;

    public void init(){
    }

    public void loop() {
        bench.init2(hardwareMap);
        if (gamepad1.dpadUpWasPressed()){
            variables[0]++;
        }
        if (gamepad1.dpadDownWasPressed()){
            variables[0]--;
        }
        if (gamepad1.dpadRightWasPressed()){
            variables[1]++;
        }
        if (gamepad1.dpadLeftWasPressed()){
            variables[1]--;
        }
        if (gamepad1.rightBumperWasPressed()){
            variables[2]++;
        }
        if (gamepad1.leftBumperWasPressed()){
            variables[2]--;
        }

        for(int i = 0; i < variables.length; i++){
            if(Math.abs(variables[i]) > maxVar){
                maxVar = variables[i];
            }
        }

        if (gamepad1.leftTriggerWasReleased()){
            int Y = 0;
            int X = 0;
            int Z = 0;
            if(variables[0] > 0){
                Y = 1;
                variables[0]--;
            }
            if(variables[0] < 0){
                Y = -1;
                variables[0]++;
            }
            if(variables[1] > 0){
                X = 1;
                variables[1]--;
            }
            if(variables[1] < 0){
                X = -1;
                variables[1]++;
            }
            if(variables[2] > 0){
                Z = 1;
                variables[2]--;
            }
            if(variables[2] < 0){
                Z = -1;
                variables[2]++;
            }

            int timerIncrement = 1;

            timer.reset();
            timer.startTime();
            while (timer.time() < maxVar){
                Y = 0;
                X = 0;
                Z = 0;

                if(timer.time() > timerIncrement){
                    if(variables[0] > 0){
                        Y = 1;
                        variables[0]--;
                    }
                    if(variables[0] < 0){
                        Y = -1;
                        variables[0]++;
                    }
                    if(variables[1] > 0){
                        X = 1;
                        variables[1]--;
                    }
                    if(variables[1] < 0){
                        X = -1;
                        variables[1]++;
                    }
                    if(variables[2] > 0){
                        Z = 1;
                        variables[2]--;
                    }
                    if(variables[2] < 0){
                        Z = -1;
                        variables[2]++;
                    }
                    timerIncrement++;
                }

                if (Y > 0) {
                    Y *= forwConst;
                }
                if(Y < 0){
                    Y *= backConst;
                }
                if(X > 0){
                    X *= strafeConst;
                }
                if(X < 0){
                    X *= strafeConst;
                }
                if(Z > 0){
                    Z *= spinConst;
                }
                if(Z < 0){
                    Z *= spinConst;
                }

                bench.Motor(Y,X,Z,false);
            }
            timer.reset();

            Arrays.fill(variables, 0);
            //if (Ycount > 0){
            //    timer.startTime();
            //    while (timer.time() < Ycount * forwConst){//
            //    bench.Motor(1,0,0,false);
            //    }
            //}
            //if (Ycount < 0){
            //    timer.startTime();
            //    while (timer.time() < -Ycount * backConst){
            //        bench.Motor(-1,0,0,false);
            //    }
            //}
            //if (Xcount > 0){
            //    timer.startTime();
            //    while (timer.time() < Xcount * strafeConst){
            //        bench.Motor(0,1,0,false);
            //    }
            //}
            //if (Xcount < 0){
            //    timer.startTime();
            //    while (timer.time() < -Xcount * strafeConst){
            //        bench.Motor(0,-1,0,false);
            //    }
            //}
            //if (Rcount > 0){
            //    timer.startTime();
            //    while (timer.time() < Rcount * spinConst){
            //        bench.Motor(0,0,1,false);
            //    }
            //}
            //if (Rcount < 0){
            //    timer.startTime();
            //    while (timer.time() < -Rcount * spinConst){
            //        bench.Motor(0,0,-1,false);
            //    }
            //}
        }
        else{

            bench.Motor(0,0,0,false);
        }

        telemetry.addData("Y-Movement", variables[0]);
        telemetry.addData("X-Movement", variables[1]);
        telemetry.addData("Rotation", variables[2]);
        telemetry.addData("maxVar", maxVar);
    }
}
