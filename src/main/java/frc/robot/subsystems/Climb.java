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

    private static final double CLIMB_SPEED = 0.1;

    public Climb() {
        this.leader = new TalonFX(LEADER_ID);
        this.follower = new TalonFX(FOLLOWER_ID);
        follower.setControl(new Follower(leader.getDeviceID(), true));

        ntDispTab("Climb")
        .add("Climb Duty Cycle", this::getDutyCycle);
    }

    public void run() {
        this.leader.set(CLIMB_SPEED); 
    }

    public void stop() {
        this.leader.set(0); 
    }

    public double getDutyCycle() {
        return leader.get();
    }
}