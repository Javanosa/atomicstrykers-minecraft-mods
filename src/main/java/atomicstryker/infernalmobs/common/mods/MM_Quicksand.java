package atomicstryker.infernalmobs.common.mods;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import atomicstryker.infernalmobs.common.InfernalMobsCore;
import atomicstryker.infernalmobs.common.MobModifier;

public class MM_Quicksand extends MobModifier
{
    public MM_Quicksand(EntityLivingBase mob)
    {
        this(mob, null);
    }
    
    public MM_Quicksand(EntityLivingBase mob, MobModifier prevMod)
    {
        this.modName = "Quicksand";
        this.nextMod = prevMod;
    }
    
    private int ticker = 0;
    
    @Override
    public boolean onUpdate(EntityLivingBase mob)
    {
    	EntityLivingBase target = getTargetFor(mob);
    	
        if (target != null
        && InfernalMobsCore.instance().getIsEntityAllowedTarget(target)
        && mob.canEntityBeSeen(target)
        && ++ticker == 50)
        {
            ticker = 0;
            target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 45, 0));
        }
        
        return super.onUpdate(mob);
    }
    
    @Override
    protected String[] getModNameSuffix()
    {
        return suffix;
    }
    private static String[] suffix = { "ofYouCantRun", "theSlowingB" };
    
    @Override
    protected String[] getModNamePrefix()
    {
        return prefix;
    }
    private static String[] prefix = { "slowing", "Quicksand" };
    
}
