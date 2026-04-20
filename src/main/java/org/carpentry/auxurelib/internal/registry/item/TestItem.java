package org.carpentry.auxurelib.internal.registry.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.carpentry.auxurelib.core.extendable.WeaponItem;
import org.carpentry.auxurelib.core.interfaces.CustomKillSourceItem;
import org.carpentry.auxurelib.core.interfaces.TwoHandedItem;
import org.carpentry.auxurelib.core.util.TimeUtils;
import org.carpentry.auxurelib.core.util.TooltipHelper;
import org.carpentry.lumenium_lite.util.render.CubeRenderer;

import java.util.List;

public class TestItem extends WeaponItem implements TwoHandedItem, CustomKillSourceItem {
    // time utility
    private int DUR = TimeUtils.seconds(10);

    public TestItem(Settings settings, int damage, float speed, boolean isSword) {
        super(settings.maxCount(1), damage, speed, isSword);
    }

    // this just renders a cube on the client side
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack stack = user.getStackInHand(hand);
        if (world.isClient){
            CubeRenderer.scheduleClient(
                    new Vec3d(user.getX(), user.getY() +1, user.getZ()),
                    4, 4, 4,
                    Vec3d.ZERO,
                    1,
                    new Identifier("minecraft", "textures/misc/white.png"), // does Identifier.ofVanilla exist i lowk forgor // nope
                    DUR,
                    false,
                    0,
                    false,
                    0,
                    1,
                    0.7f
            );
        }
        return TypedActionResult.success(stack);
    }

    // name color ig
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().styled(style -> style.withColor(0xff004f));
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(TooltipHelper.createLiteral("Testing Tooltip", Formatting.GOLD));
    }

    @Override
    public DamageSource getKillSource(PlayerEntity player, ItemStack stack) {
        return DamageSource.MAGIC;
    }
}