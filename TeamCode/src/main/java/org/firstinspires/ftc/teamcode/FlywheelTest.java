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
    private int targetVelocity = 0;
    private double F = 0;
    private double P = 0;

    private double[] PFstepSizes = {10.0, 1.0, 0.1, 0.001, 0.0001};
    private int[] wheelStepSizes = {1000,100,10,1, 0};
    private int stepIndex = 1;
    @Override
    public void init()
    {
        flywheelMotor = hardwareMap.get(DcMotorEx.class, "Flywheel");
        flywheelMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheelMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P, 0, 0, F);
        flywheelMotor.setPIDFCoefficients(DcMotorEx.RunMode.RUN_USING_ENCODER, pidfCoefficients);
        telemetry.addLine("Init complete");
    }

    @Override
    public void loop()
    {


        //Circle pressed changes step size
        if (gamepad1.circleWasPressed())
        {
            stepIndex = (stepIndex + 1) % PFstepSizes.length;
        }

        //DPad left decrements F value
        if (gamepad1.dpadLeftWasPressed())
        {
            F -= PFstepSizes[stepIndex];
        }
        //DPad right increments F value
        if (gamepad1.dpadRightWasPressed())
        {
            F += PFstepSizes[stepIndex];
        }
        //DPad up increments P value
        if (gamepad1.dpadUpWasPressed())
        {
            P += PFstepSizes[stepIndex];
        }
        //DPad down decrements P value
        if (gamepad1.dpadDownWasPressed())
        {
            P -= PFstepSizes[stepIndex];
        }
        if(gamepad1.triangleWasPressed()){
            targetVelocity += wheelStepSizes[stepIndex];
        }
        if(gamepad1.crossWasPressed()){
            targetVelocity -= wheelStepSizes[stepIndex];
        }

        //new PIDF coefficients
        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P, 0, 0, F);
        flywheelMotor.setPIDFCoefficients(DcMotorEx.RunMode.RUN_USING_ENCODER, pidfCoefficients);
        // set velocity
        flywheelMotor.setVelocity(targetVelocity);

        double currentVelocity = flywheelMotor.getVelocity();
        double error = targetVelocity - currentVelocity;


        telemetry.addData("Step Index", PFstepSizes[stepIndex]);
        telemetry.addData("Target Velocity", targetVelocity);
        telemetry.addData("Current Velocity","%.2f",currentVelocity);
        telemetry.addData("Error (Abs)","%.2f",error);
        telemetry.addData("Tuning P","%.4f (DPad U/D)",P);
        telemetry.addData("Tuning F","%.4f (Dpad L/R)",F);
    }
}
