package frc.robot.commands;

import frc.robot.subsystems.Climb;
import frc.robot.ManualControls;

import edu.wpi.first.wpilibj2.command.Command;

import static frc.robot.utility.NetworkTable.NtValueDisplay.ntDispTab;
public class ClimbCommand extends Command {

    final Climb climb;
    final ManualControls controls;
    private double test;

    public ClimbCommand(Climb climb, ManualControls controls) {
        this.climb = climb;
        this.controls = controls;
        this.test = 0;
        addRequirements(climb);

        ntDispTab("AAAAA")
        .add("Climb Test", this::getTest);
    }

    public double getTest() {
        return test;
    }

    @Override
    public void initialize() {
        climb.stop();
    }
    
    @Override
    public void execute() {
       if (controls.getRunClimb()) {
           test = 1;
           climb.run();
       } else {
           climb.stop();
           test = 0;
       }
    }

    @Override
    public void end(boolean interrupted) {
        climb.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
