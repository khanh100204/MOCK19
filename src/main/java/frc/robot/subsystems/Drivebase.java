/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Drivebase extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public VictorSP leftMotor = new VictorSP(RobotMap.lMotor);
  public VictorSP leftSlave = new VictorSP(RobotMap.lsMotor);
  public VictorSP rightMotor = new VictorSP(RobotMap.rMotor);
  public VictorSP rightSlave = new VictorSP(RobotMap.rsMotor);
  public double turnRight = -1.0;
  public double turnLeft = 1.0;
  public void setLeft(double x) {
    leftMotor.set(x);
    leftSlave.set(x);
  }
  public void setRight(double x) {
    rightMotor.set(x*-0.85);
    rightSlave.set(x*-0.85);
  }
  public void straight(double speed, long time){
    // time=time*1000;
    // long realtime = (new Double(time)).longValue();
    long realtime = time*1000;
    setRight(speed);
    setLeft(speed);
    try{Thread.sleep(realtime);}catch(InterruptedException e){}
    setRight(0);
    setLeft(0);
  }
  public void turn(double speed, double turn, long time) {
    // time=time*1000;
    // long realtime = (new Double(time)).longValue();
    long realtime = time*1000;
    setRight(turn*speed);
    setLeft(-turn*speed);
    try{Thread.sleep(realtime);}catch(InterruptedException e){}
    setRight(0);
    setLeft(0);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
