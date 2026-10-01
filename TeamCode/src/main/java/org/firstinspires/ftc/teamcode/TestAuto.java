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

    double forwConst = 1;
    double backConst = 0.8;
    double strafeConst = 1;
    double spinConst = 0.4;

    public void init(){
        bench.init2(hardwareMap);
        int count = 0;
        while (!gamepad1.left_trigger_pressed){
            if (gamepad1.dpad_up){
                count++;
            }
            if (gamepad1.dpad_down){
                count--;
            }
            telemetry.addData("fAmount: ", count);
        }
        timer.startTime();
        while (timer.time() < count * forwConst){
            bench.Motor(-1,0,0,false);
        }
        bench.Motor(0,0,0,false);

        timer.reset();
        count = 0;
        while (!gamepad1.left_trigger_pressed){
            if (gamepad1.dpad_up){
                count++;
            }
            if (gamepad1.dpad_down){
                count--;
            }
            telemetry.addData("bAmount: ", count);
        }
        timer.startTime();
        while (timer.time() < count * backConst){
            bench.Motor(1,0,0,false);
        }
        bench.Motor(0,0,0,false);

        timer.reset();
        count = 0;
        while (!gamepad1.left_trigger_pressed){
            if (gamepad1.dpad_up){
                count++;
            }
            if (gamepad1.dpad_down){
                count--;
            }
            telemetry.addData("rAmount: ", count);
        }
        timer.startTime();
        while (timer.time() < count * strafeConst){
            bench.Motor(0,1,0,false);
        }
        bench.Motor(0,0,0,false);

        timer.reset();
        count = 0;
        while (!gamepad1.left_trigger_pressed){
            if (gamepad1.dpad_up){
                count++;
            }
            if (gamepad1.dpad_down){
                count--;
            }
            telemetry.addData("lAmount: ", count);
        }
        timer.startTime();
        while (timer.time() < count * strafeConst){
            bench.Motor(0,-1,0,false);
        }
        bench.Motor(0,0,0,false);

        timer.reset();
        count = 0;
        while (!gamepad1.left_trigger_pressed){
            if (gamepad1.dpad_up){
                count++;
            }
            if (gamepad1.dpad_down){
                count--;
            }
            telemetry.addData("clockAmount(30*): ", count);
        }
        timer.startTime();
        while (timer.time() < count * spinConst){
            bench.Motor(0,0,1,false);
        }
        bench.Motor(0,0,0,false);

        timer.reset();
        count = 0;
        while (!gamepad1.left_trigger_pressed){
            if (gamepad1.dpad_up){
                count++;
            }
            if (gamepad1.dpad_down){
                count--;
            }
            telemetry.addData("anticlockAmount(30*): ", count);
        }
        timer.startTime();
        while (timer.time() < count * spinConst){
            bench.Motor(0,0,-1,false);
        }
        bench.Motor(0,0,0,false);
    }

    public void loop() { }
}
