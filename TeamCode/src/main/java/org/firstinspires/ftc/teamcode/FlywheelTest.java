package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@TeleOp
public class FlywheelTest extends OpMode {

    public DcMotorEx flywheelMotor;

    double highVelocity = 1500;

    double lowVelocity = 900;
    double targetVelocity = highVelocity;
    double F = 0;
    double P = 0;

    double[] stepSizes = {10.0, 1.0, 0.1, 0.001, 0.0001};
    int stepIndex = 1;
    @Override
    public void init()
    {
        flywheelMotor = hardwareMap.get(DcMotorEx.class, "leftFront");
        flywheelMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheelMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P, 0, 0, F);
        flywheelMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);
        telemetry.addLine("Init complete");
    }

    @Override
    public void loop()
    {
        if (gamepad1.yWasPressed())
        {
            if (targetVelocity == highVelocity)
            {
                targetVelocity = lowVelocity;
            }
            else
            {
                targetVelocity = highVelocity;
            }
        }

        if (gamepad1.bWasPressed())
        {
            stepIndex = (stepIndex + 1) % stepSizes.length;
        }

        if (gamepad1.dpadLeftWasPressed())
        {
            F -= stepSizes[stepIndex];
        }
        if (gamepad1.dpadRightWasPressed())
        {
            F += stepSizes[stepIndex];
        }
        if (gamepad1.dpadUpWasPressed())
        {
            P += stepSizes[stepIndex];
        }
        if (gamepad1.dpadDownWasPressed())
        {
            P -= stepSizes[stepIndex];
        }

        //new PIDF coefficients
        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P, 0, 0, F);
        flywheelMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);

        // set velocity
        flywheelMotor.setVelocity(targetVelocity);

        double currentVelocity = flywheelMotor.getVelocity();
        double error = targetVelocity - currentVelocity;


        telemetry.addData("Step Index","%.4d (B)", stepIndex);
        telemetry.addData("Target Velocity", targetVelocity);
        telemetry.addData("Current Velocity","%.2f",currentVelocity);
        telemetry.addData("Error (Abs)","%.2f",error);
        telemetry.addData("Tuning P","%.4f (DPad U/D)",P);
        telemetry.addData("Tuning F","%.4f (Dpad L/R)",F);
    }
}
