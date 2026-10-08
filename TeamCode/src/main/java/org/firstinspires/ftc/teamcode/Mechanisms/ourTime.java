package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class ourTime extends OpMode{
    @Override
    public void init(){

    }

    @Override
    public void loop(){

    }

    public void sleep(int milliseconds){
        ElapsedTime timer = new ElapsedTime();
        timer.startTime();
        while (timer.time() < milliseconds / 1000){

        }
        timer.reset();
    }
}
