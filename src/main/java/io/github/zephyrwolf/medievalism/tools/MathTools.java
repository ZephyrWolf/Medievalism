package io.github.zephyrwolf.medievalism.tools;

public final class MathTools
{
    public static double asymmetricCos(double rad, double skew)
    {
        double t = (rad / (2f * Math.PI)) % 1.0f; // [0,1)
        // double s = Math.abs(skew) % 1f; // [0,1) // I should guard against div by zero
        double s = Math.min(0.999999, Math.max(0.000001, Math.abs(skew) % 1f)); // [0.000001,0.999999]
        double f1 = 1f / s;
        double f2 = 1f / (1.0f - s);
        return (t < skew)
                ? Math.cos(Math.PI * f1 * (t % skew)) // [0,skew)->[0,1)
                : Math.cos(Math.PI * f2 * ((t - skew) % (1f - skew)) + Math.PI); // [skew,1)->[0,1)
    }

    public static double asymmetricSin(double rad, double skew)
    {
        return asymmetricCos(rad - Math.PI/2, skew);
    }
}
