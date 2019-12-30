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
public class Intake extends Subsystem {
  // Put methods for controllin.g this subsystem
  // here. Call these from Commands.
  public VictorSP Intaker = new VictorSP(RobotMap.intake);
  public void INTAKE() {
    Intaker.set(-0.7);
  }
  public void stop() {
    Intaker.stopMotor();
  }
  public void tIntake(double time) {
    time=time*1000;
    long realtime = (new Double(time)).longValue();
    INTAKE();
    try{Thread.sleep(realtime);}catch(InterruptedException e){}
    stop();
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
