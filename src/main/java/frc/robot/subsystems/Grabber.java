package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.utility.NetworkTable.NtValueDisplay.ntDispTab;

public class Grabber extends SubsystemBase {
    
    private SparkMax grabberMotor;
    private final SlewRateLimiter rateLimiter;

    private static final int GRABBER_MOTOR_ID = 17;

    private static final double INTAKE_SPEED = 0.5;
    private static final double OUTTAKE_SPEED = -0.5;

    public Grabber() {

        this.grabberMotor = new SparkMax(GRABBER_MOTOR_ID, MotorType.kBrushless);
        rateLimiter = new SlewRateLimiter(1.0 / 0.5); // TODO: get rid of this limiter, you dont need a limiter for a simple roller, adds unnecessary complication

        ntDispTab("Grabber")
            .add("Grabber Duty Cycle", this::getDutyCycle);
    }

    public void intake() {
        grabberMotor.set(rateLimiter.calculate(INTAKE_SPEED));
    }

    public void outtake() {
        grabberMotor.set(rateLimiter.calculate(OUTTAKE_SPEED));
    }

    public void stop() {
        grabberMotor.set(0);
    }

    public double getDutyCycle() {
        return grabberMotor.get();
    }
}
