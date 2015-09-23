package car;

import com.pheiffware.lib.geometry.Vec3D;

public class Sensor
{
	private double angleInRadians;
	private final Vec3D direction;
	private final Vec3D position;

	public Sensor(double angle, Vec3D position)
	{
		direction = new Vec3D(0, 0, 0);
		setAngle(angle);
		this.position = position;
	}

	public Sensor(Sensor sensor)
	{
		angleInRadians = sensor.angleInRadians;
		direction = sensor.direction;
		position = new Vec3D(sensor.position);
	}

	private void setAngle(double angleInRadians)
	{
		this.angleInRadians = angleInRadians;
		direction.x = Math.cos(angleInRadians);
		direction.y = Math.sin(angleInRadians);
		direction.z = 0;
	}

	public final double getAngle()
	{
		return angleInRadians;
	}

	public final Vec3D getDirection()
	{
		return direction;
	}

	public final Vec3D getPosition()
	{
		return position;
	}

	public void translate(Vec3D translate)
	{
		position.addTo(translate);
	}

	public final void rotateAround2D(final double angleRotatedRadians, final Vec3D centerOfRotation)
	{
		position.rotateAround2D(angleRotatedRadians, centerOfRotation);
		setAngle(angleInRadians + angleRotatedRadians);
	}

}
