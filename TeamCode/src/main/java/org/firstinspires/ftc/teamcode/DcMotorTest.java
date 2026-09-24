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
        if (Math.abs(gamepad1.left_stick_y) > 0.1 || Math.abs(gamepad1.left_stick_x) > 0.1 || Math.abs(gamepad1.right_stick_x) > 0.1){
            bench.Motor(gamepad1.left_stick_y,gamepad1.left_stick_x, gamepad1.right_stick_x, gamepad1.circle);
        }
        else{
            bench.Motor(0,0, 0, false);
        }

//        telemetry.addData("a", gamepad1.a);
//        telemetry.addData("b", gamepad1.b);
//        telemetry.addData("y", gamepad1.y);
//        telemetry.addData("x", gamepad1.x);
//        telemetry.addData("Lx", gamepad1.left_stick_x);
//        telemetry.addData("Ly", gamepad1.left_stick_y);
//        telemetry.addData("Rx", gamepad1.right_stick_x);
//        telemetry.addData("Ry", gamepad1.right_stick_y);
//        telemetry.addData("back", gamepad1.back);
//        telemetry.addData("cross", gamepad1.cross);
//        telemetry.addData("guide", gamepad1.guide);
//        telemetry.addData("circle", gamepad1.circle);
//        telemetry.addData("triangle", gamepad1.triangle);
//        telemetry.addData("ps", gamepad1.ps);
//        telemetry.addData("start", gamepad1.start);
//        telemetry.addData("square", gamepad1.square);

    }
}
