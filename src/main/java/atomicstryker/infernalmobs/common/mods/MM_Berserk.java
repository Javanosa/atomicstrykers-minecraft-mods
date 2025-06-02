package atomicstryker.infernalmobs.common.mods;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.DamageSource;
import atomicstryker.infernalmobs.common.InfernalMobsCore;
import atomicstryker.infernalmobs.common.MobModifier;

public class MM_Berserk extends MobModifier
{
    public MM_Berserk(EntityLivingBase mob)
    {
        this(mob, null);
    }
    
    public MM_Berserk(EntityLivingBase mob, MobModifier prevMod)
    {
        this.modName = "Berserk";
        this.nextMod = prevMod;
    }
    
    @Override
    public float onAttack(EntityLivingBase entity, DamageSource source, float damage)
    {
        if (entity != null)
        {
            source.getEntity().attackEntityFrom(DamageSource.generic, damage);
            damage *= 2;
            damage = InfernalMobsCore.instance().getLimitedDamage(damage);
        }
        
        return super.onAttack(entity, source, damage);
    }
    
    @Override
    public Class<?>[] getBlackListMobClasses()
    {
        return disallowed;
    }
    private static Class<?>[] disallowed = { EntityCreeper.class };
    
    @Override
    protected String[] getModNameSuffix()
    {
        return suffix;
    }
    private static String[] suffix = { "ofRecklessness", "theRaging", "ofSmashing" };
    
    @Override
    protected String[] getModNamePrefix()
    {
        return prefix;
    }
    private static String[] prefix = { "reckless", "raging", "smashing" };
    
}
