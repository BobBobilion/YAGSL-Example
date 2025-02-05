package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.controls.Follower;

import static frc.robot.utility.NetworkTable.NtValueDisplay.ntDispTab;
public class Climb extends SubsystemBase {
    
    private TalonFX leader;
    private TalonFX follower;
     
    private static final int LEADER_ID = 20;
    private static final int FOLLOWER_ID = 21;

    private static final double CLIMB_SPEED = 0.7;

    public Climb() {
        this.leader = new TalonFX(LEADER_ID, "Canivore");
        this.follower = new TalonFX(FOLLOWER_ID, "Canivore"); // TODO: THIS SHOULD BE MADE A FOLLOWER
                                                                    //  Rn this is just another motor, not a follower


        ntDispTab("Climb")
        .add("Climb Duty Cycle", this::getDutyCycle);
    }

    public void run() {
        this.leader.set(CLIMB_SPEED); 
        this.follower.set(-CLIMB_SPEED);
    }

    public void stop() {
        this.leader.set(0); 
        this.follower.set(0);
    }

    // TODO: Add a reverse climb (climb down) function

    public double getDutyCycle() {
        return leader.get();
    }
}