package app.ccls.bcr.block;

import com.mojang.serialization.MapCodec;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.enums.BlockFace;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class Pillar extends HorizontalFacingBlock implements Waterloggable {
    public static final MapCodec<Pillar> CODEC = createCodec(Pillar::new);
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final EnumProperty<BlockFace> FACE = Properties.BLOCK_FACE;

    // Floor shapes
    protected static final VoxelShape NORTH_FLOOR = VoxelShapes.cuboid(0.0f, 8.0f/16.0f, 0.0f, 8.0f/16.0f, 16.0f/16.0f, 16.0f/16.0f);
    protected static final VoxelShape SOUTH_FLOOR = VoxelShapes.cuboid(8.0f/16.0f, 8.0f/16.0f, 0.0f, 16.0f/16.0f, 16.0f/16.0f, 16.0f/16.0f);
    protected static final VoxelShape EAST_FLOOR = VoxelShapes.cuboid(0.0f, 8.0f/16.0f, 0.0f, 16.0f/16.0f, 16.0f/16.0f, 8.0f/16.0f);
    protected static final VoxelShape WEST_FLOOR = VoxelShapes.cuboid(0.0f, 8.0f/16.0f, 8.0f/16.0f, 16.0f/16.0f, 16.0f/16.0f, 16.0f/16.0f);

    // Wall shapes
    protected static final VoxelShape NORTH_WALL = VoxelShapes.cuboid(8.0f/16.0f, 0.0f, 8.0f/16.0f, 16.0f/16.0f, 16.0f/16.0f, 16.0f/16.0f);
    protected static final VoxelShape SOUTH_WALL = VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 8.0f/16.0f, 16.0f/16.0f, 8.0f/16.0f);
    protected static final VoxelShape EAST_WALL = VoxelShapes.cuboid(0.0f, 0.0f, 8.0f/16.0f, 8.0f/16.0f, 16.0f/16.0f, 16.0f/16.0f);
    protected static final VoxelShape WEST_WALL = VoxelShapes.cuboid(8.0f/16.0f, 0.0f, 0.0f, 16.0f/16.0f, 16.0f/16.0f, 8.0f/16.0f);

    // Ceiling shapes
    protected static final VoxelShape NORTH_CEILING = VoxelShapes.cuboid(8.0f/16.0f, 0.0f, 0.0f, 16.0f/16.0f, 8.0f/16.0f, 16.0f/16.0f);
    protected static final VoxelShape SOUTH_CEILING = VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 8.0f/16.0f, 8.0f/16.0f, 16.0f/16.0f);
    protected static final VoxelShape EAST_CEILING = VoxelShapes.cuboid(0.0f, 0.0f, 8.0f/16.0f, 16.0f/16.0f, 8.0f/16.0f, 16.0f/16.0f);
    protected static final VoxelShape WEST_CEILING = VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 16.0f/16.0f, 8.0f/16.0f, 8.0f/16.0f);

    public Pillar(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState()
            .with(FACING, Direction.NORTH)
            .with(FACE, BlockFace.WALL)
            .with(WATERLOGGED, false));
    }

    @Override
    protected MapCodec<? extends Pillar> getCodec() {
        return CODEC;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, FACE, WATERLOGGED);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        BlockFace face = state.get(FACE);

        return switch (face) {
            case FLOOR -> switch (dir) {
                case NORTH -> NORTH_FLOOR;
                case SOUTH -> SOUTH_FLOOR;
                case EAST -> EAST_FLOOR;
                case WEST -> WEST_FLOOR;
                default -> NORTH_FLOOR;
            };
            case WALL -> switch (dir) {
                case NORTH -> NORTH_WALL;
                case SOUTH -> SOUTH_WALL;
                case EAST -> EAST_WALL;
                case WEST -> WEST_WALL;
                default -> NORTH_WALL;
            };
            case CEILING -> switch (dir) {
                case NORTH -> NORTH_CEILING;
                case SOUTH -> SOUTH_CEILING;
                case EAST -> EAST_CEILING;
                case WEST -> WEST_CEILING;
                default -> NORTH_CEILING;
            };
        };
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getSide();
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        
        return this.getDefaultState()
            .with(FACE, getBlockFace(direction))
            .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite())
            .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
    }

    private BlockFace getBlockFace(Direction direction) {
        return switch (direction) {
            case UP -> BlockFace.CEILING;
            case DOWN -> BlockFace.FLOOR;
            default -> BlockFace.WALL;
        };
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
}