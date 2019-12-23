/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Shoot extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Spark shooter1 = new Spark(RobotMap.shootaa);
  Spark shooter2 = new Spark(RobotMap.shootbb);
  PWMTalonSRX loader = new PWMTalonSRX(RobotMap.loading);

  public void shoot(){
    shooter1.set(1);
    shooter2.set(-1);
  }
  public void load(double speed){
    loader.set(speed);
  }
  public void stop(){
    shooter1.stopMotor();
    shooter2.stopMotor();
    loader.stopMotor();
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
