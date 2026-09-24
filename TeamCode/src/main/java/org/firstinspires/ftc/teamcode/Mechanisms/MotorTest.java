package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.ftccommon.external.OnCreateEventLoop;

@TeleOp
public class MotorTest extends OpMode{

    private DcMotor LFmotor;
    private DcMotor LBmotor;
    private DcMotor RFmotor;
    private DcMotor RBmotor;

    @Override
    public void init(){

    }


    public void init2(HardwareMap hwMap){
        LFmotor = hwMap.get(DcMotor.class, "leftFront");
        LFmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBmotor = hwMap.get(DcMotor.class, "leftBack");
        LBmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFmotor = hwMap.get(DcMotor.class, "rightFront");
        RFmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBmotor = hwMap.get(DcMotor.class, "rightBack");
        RBmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop(){

    }

    public void Motor(double speedY, double speedX, double rotation){
        double LF = -((speedY - speedX - rotation) / 3);
        double LB = -((speedY + speedX - rotation) / 3);
        double RF = (speedY + speedX + rotation) / 3;
        double RB = (speedY - speedX + rotation) / 3;
        LFmotor.setPower(LF);
        LBmotor.setPower(LB);
        RFmotor.setPower(RF);
        RBmotor.setPower(RB);
    }
}