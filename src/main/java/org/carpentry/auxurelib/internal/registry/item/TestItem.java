package org.carpentry.auxurelib.internal.registry.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.carpentry.auxurelib.core.impl.CustomStackColor;
import org.carpentry.auxurelib.core.impl.TwoHandedItem;
import org.carpentry.auxurelib.core.util.TimeUtils;
import org.carpentry.lumenium_lite.util.render.CubeRenderer;

public class TestItem extends Item implements TwoHandedItem, CustomStackColor {

    public int DUR = TimeUtils.ticksToMinutes(2);

    public TestItem(Settings settings) {
        super(settings.maxCount(1));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack stack = user.getStackInHand(hand);
        if (world.isClient){
            CubeRenderer.scheduleClient(
                    new Vec3d(user.getX(), user.getY() +1, user.getZ()),
                    4, 4, 4,
                    Vec3d.ZERO,
                    1,
                    new Identifier("minecraft", "textures/misc/white.png"),
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

    @Override
    public int getHexColor(ItemStack stack) {
        return 0xff004f;
    }

    @Override
    public Text getName(ItemStack stack) {
        return getColoredName(stack);
    }
}
