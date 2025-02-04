package frc.robot.commands;

import frc.robot.subsystems.Climb;
import frc.robot.ManualControls;

import edu.wpi.first.wpilibj2.command.Command;

public class ClimbCommand extends Command {

    final Climb climb;
    final ManualControls controls;

    public ClimbCommand(Climb climb, ManualControls controls) {
        this.climb = climb;
        this.controls = controls;
        addRequirements(climb);
    }

    @Override
    public void initialize() {
        climb.stop();
    }
    
    @Override
    public void execute() {
        if (controls.getRunClimb()) {
            climb.run();
        } else {
            climb.stop();
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
