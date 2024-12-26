package app.ccls.bcr.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import app.ccls.bcr.BCR;

import java.util.HashSet;
import java.util.Set;

public class PanelBlockEntity extends BlockEntity {
    private final Set<Direction> panels = new HashSet<>();

    public PanelBlockEntity(BlockPos pos, BlockState state) {
        super(BCR.PANEL_BLOCK_ENTITY, pos, state);
        addPanel(state.get(Properties.FACING));
    }

    public boolean hasPanel(Direction dir) {
        return panels.contains(dir);
    }

    public void addPanel(Direction dir) {
        if (!hasPanel(dir)) {
            panels.add(dir);
            markDirty();
        }
    }

    public Set<Direction> getPanels() {
        return panels;
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        int[] dirs = panels.stream().mapToInt(Direction::getId).toArray();
        nbt.putIntArray("panels", dirs);
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        panels.clear();
        int[] dirs = nbt.getIntArray("panels");
        for (int dir : dirs) {
            panels.add(Direction.byId(dir));
        }
    }
}