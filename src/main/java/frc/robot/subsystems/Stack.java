/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Stack extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public WPI_TalonSRX stacker = new WPI_TalonSRX(RobotMap.stacker);
  public void clean1(){
    stacker.set(0.4);
  }
  public void clean2(){
    stacker.set(-0.4);
  }
  public void stop(){
    stacker.stopMotor();
  }
  boolean rev = false;
  double start;
  public void clean(boolean x, double interval) {
    if (x) {
      if (rev == false) {
        start = interval;
        rev = true;
      }
      if (Timer.getFPGATimestamp() - start >= 1.0) {
        clean2();
      }
      else {
        clean1();
      }
    }
    else {
      stop();
      rev = false;
    }
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
