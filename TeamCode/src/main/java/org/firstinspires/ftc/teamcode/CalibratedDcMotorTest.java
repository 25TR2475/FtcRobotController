package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import org.firstinspires.ftc.teamcode.Mechanisms.MotorTest;

@TeleOp
public class CalibratedDcMotorTest extends OpMode
{

    public DcMotorEx flywheelMotor;
    MotorTest bench = new MotorTest();

    @Override
    public void init()
    {
        bench.init2(hardwareMap);
        flywheelMotor = hardwareMap.get(DcMotorEx.class, "leftFront");
        flywheelMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheelMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop()
    {
        if (Math.abs(gamepad1.left_stick_y) > 0.1 || Math.abs(gamepad1.left_stick_x) > 0.1 || Math.abs(gamepad1.right_stick_x) > 0.1){
            bench.Motor(gamepad1.left_stick_y,gamepad1.left_stick_x, gamepad1.right_stick_x, gamepad1.circle);
        }
        else{
            bench.Motor(0,0, 0, false);
        }


    }
}
