package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class ManualControls {
    
    private CommandXboxController driverXbox;
    private XboxController secondXbox;

    public ManualControls(CommandXboxController driverXbox, XboxController secondXbox) {
        this.driverXbox = driverXbox;
        this.secondXbox = secondXbox;
    }

    public boolean grabberOuttake() {
        return secondXbox.getBButtonPressed();
    }

    public boolean grabberIntake() {
        return secondXbox.getAButtonPressed();
    }

    public boolean getRunClimb() {
        return secondXbox.getXButtonPressed();
    }

}
