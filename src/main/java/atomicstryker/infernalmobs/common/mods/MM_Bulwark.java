package atomicstryker.infernalmobs.common.mods;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import atomicstryker.infernalmobs.common.MobModifier;

public class MM_Bulwark extends MobModifier
{
    public MM_Bulwark(EntityLivingBase mob)
    {
        this(mob, null);
    }
    
    public MM_Bulwark(EntityLivingBase mob, MobModifier prevMod)
    {
        this.modName = "Bulwark";
        this.nextMod = prevMod;
    }
    
    @Override
    public float onHurt(EntityLivingBase mob, DamageSource source, float damage)
    {
        return super.onHurt(mob, source, Math.max(damage/2, 1));
    }
    
    @Override
    protected String[] getModNameSuffix()
    {
        return suffix;
    }
    private static String[] suffix = { "ofTurtling", "theDefender", "ofeffingArmor" };
    
    @Override
    protected String[] getModNamePrefix()
    {
        return prefix;
    }
    private static String[] prefix = { "turtling", "defensive", "armoured" };
    
}
