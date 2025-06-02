package atomicstryker.infernalmobs.common.mods;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import atomicstryker.infernalmobs.common.InfernalMobsCore;
import atomicstryker.infernalmobs.common.MobModifier;

public class MM_Weakness extends MobModifier
{
    public MM_Weakness(EntityLivingBase mob)
    {
       this(mob, null);
    }
    
    public MM_Weakness(EntityLivingBase mob, MobModifier prevMod)
    {
        this.modName = "Weakness";
        this.nextMod = prevMod;
    }
    
    @Override
    public float onHurt(EntityLivingBase mob, DamageSource source, float damage)
    {
    	Entity attacker = source.getEntity();
    	
        if (attacker != null
        && (attacker instanceof EntityLivingBase)
        && InfernalMobsCore.instance().getIsEntityAllowedTarget(attacker))
        {
            ((EntityLivingBase) attacker).addPotionEffect(new PotionEffect(Potion.weakness.id, 120, 0));
        }
        
        return super.onHurt(mob, source, damage);
    }
    
    @Override
    public float onAttack(EntityLivingBase entity, DamageSource source, float damage)
    {
        if (entity != null
        && InfernalMobsCore.instance().getIsEntityAllowedTarget(entity))
        {
            entity.addPotionEffect(new PotionEffect(Potion.weakness.id, 120, 0));
        }
        
        return super.onAttack(entity, source, damage);
    }
    
    @Override
    protected String[] getModNameSuffix()
    {
        return suffix;
    }
    private static String[] suffix = { "ofApathy", "theDeceiver" };
    
    @Override
    protected String[] getModNamePrefix()
    {
        return prefix;
    }
    private static String[] prefix = { "apathetic", "deceiving" };
}
