package atomicstryker.infernalmobs.common.mods;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import atomicstryker.infernalmobs.common.MobModifier;

public class MM_Exhaust extends MobModifier
{
    public MM_Exhaust(EntityLivingBase mob)
    {
        this(mob, null);
    }
    
    public MM_Exhaust(EntityLivingBase mob, MobModifier prevMod)
    {
        this.modName = "Exhaust";
        this.nextMod = prevMod;
    }
    
    @Override
    public float onHurt(EntityLivingBase mob, DamageSource source, float damage)
    {
    	Entity attacker = source.getEntity();
        if (attacker != null
        && (attacker instanceof EntityPlayer))
        {
            ((EntityPlayer) attacker).addExhaustion(1F);
        }
        
        return super.onHurt(mob, source, damage);
    }
    
    @Override
    public float onAttack(EntityLivingBase entity, DamageSource source, float damage)
    {
        if (entity != null
        && entity instanceof EntityPlayer)
        {
            ((EntityPlayer) entity).addExhaustion(1F);
        }
        
        return super.onAttack(entity, source, damage);
    }
    
    @Override
    protected String[] getModNameSuffix()
    {
        return suffix;
    }
    private static String[] suffix = { "ofFatigue", "theDrainer" };
    
    @Override
    protected String[] getModNamePrefix()
    {
        return prefix;
    }
    private static String[] prefix = { "exhausting", "draining" };
    
}
