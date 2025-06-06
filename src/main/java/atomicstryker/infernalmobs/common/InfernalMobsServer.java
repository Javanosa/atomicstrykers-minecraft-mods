package atomicstryker.infernalmobs.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.entity.EntityLivingBase;

public class InfernalMobsServer implements ISidedProxy
{
    
	private Map<EntityLivingBase, MobModifier> rareMobsServer;
    
    public InfernalMobsServer()
    {
        rareMobsServer = new HashMap<EntityLivingBase, MobModifier>();
    }
    
    @Override
    public void preInit()
    {
        // NOOP
    }

    @Override
    public void load()
    {
        // NOOP
    }

    @Override
    public Map<EntityLivingBase, MobModifier> getRareMobs(boolean client)
    {
    	return rareMobsServer;
    }

    @Override
    public void onHealthPacketForClient(String stringData, int entID, float health, float maxhealth)
    {
        // NOOP
    }

    @Override
    public void onKnockBackPacket(float xv, float zv)
    {
        // NOOP
    }

    @Override
    public void onMobModsPacketToClient(String stringData, int entID)
    {
        // NOOP
    }

    @Override
    public void onVelocityPacket(float xv, float yv, float zv)
    {
        // NOOP
    }

    @Override
    public void onAirPacket(int air, boolean keep)
    {
        // NOOP
    }

}
