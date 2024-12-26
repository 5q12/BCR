package app.ccls.bcr.block;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import app.ccls.bcr.block.entity.PanelBlockEntity;
import net.minecraft.block.Block;
import org.jetbrains.annotations.Nullable;
import com.mojang.serialization.MapCodec;

public class Panel extends BlockWithEntity implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty HAS_PANEL_NORTH = BooleanProperty.of("has_panel_north");
    public static final BooleanProperty HAS_PANEL_SOUTH = BooleanProperty.of("has_panel_south");
    public static final BooleanProperty HAS_PANEL_EAST = BooleanProperty.of("has_panel_east");
    public static final BooleanProperty HAS_PANEL_WEST = BooleanProperty.of("has_panel_west");
    public static final BooleanProperty HAS_PANEL_UP = BooleanProperty.of("has_panel_up");
    public static final BooleanProperty HAS_PANEL_DOWN = BooleanProperty.of("has_panel_down");

    private static final float THICKNESS = 0.01f;

    protected static final VoxelShape SHAPE_UP = VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, THICKNESS, 1.0f);
    protected static final VoxelShape SHAPE_DOWN = VoxelShapes.cuboid(0.0f, 1.0f - THICKNESS, 0.0f, 1.0f, 1.0f, 1.0f);
    protected static final VoxelShape SHAPE_NORTH = VoxelShapes.cuboid(0.0f, 0.0f, 1.0f - THICKNESS, 1.0f, 1.0f, 1.0f);
    protected static final VoxelShape SHAPE_SOUTH = VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, THICKNESS);
    protected static final VoxelShape SHAPE_EAST = VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, THICKNESS, 1.0f, 1.0f);
    protected static final VoxelShape SHAPE_WEST = VoxelShapes.cuboid(1.0f - THICKNESS, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);

    public Panel(Settings settings) {
        super(settings.nonOpaque());
        BlockState defaultState = this.stateManager.getDefaultState()
            .with(Properties.FACING, Direction.NORTH)
            .with(WATERLOGGED, false)
            .with(HAS_PANEL_NORTH, false)
            .with(HAS_PANEL_SOUTH, false)
            .with(HAS_PANEL_EAST, false)
            .with(HAS_PANEL_WEST, false)
            .with(HAS_PANEL_UP, false)
            .with(HAS_PANEL_DOWN, false);
        this.setDefaultState(defaultState);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(
            Properties.FACING, 
            WATERLOGGED,
            HAS_PANEL_NORTH,
            HAS_PANEL_SOUTH,
            HAS_PANEL_EAST,
            HAS_PANEL_WEST,
            HAS_PANEL_UP,
            HAS_PANEL_DOWN
        );
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        VoxelShape shape = VoxelShapes.empty();
        
        if (state.get(HAS_PANEL_NORTH)) {
            shape = VoxelShapes.union(shape, SHAPE_NORTH);
        }
        if (state.get(HAS_PANEL_SOUTH)) {
            shape = VoxelShapes.union(shape, SHAPE_SOUTH);
        }
        if (state.get(HAS_PANEL_EAST)) {
            shape = VoxelShapes.union(shape, SHAPE_EAST);
        }
        if (state.get(HAS_PANEL_WEST)) {
            shape = VoxelShapes.union(shape, SHAPE_WEST);
        }
        if (state.get(HAS_PANEL_UP)) {
            shape = VoxelShapes.union(shape, SHAPE_UP);
        }
        if (state.get(HAS_PANEL_DOWN)) {
            shape = VoxelShapes.union(shape, SHAPE_DOWN);
        }
    
        return shape.isEmpty() ? VoxelShapes.empty() : shape;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PanelBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getOutlineShape(state, world, pos, context);
    }
    

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        Direction newFacing = context.getSide();
        
        if (context.getWorld().getBlockState(context.getBlockPos()).getBlock() instanceof Panel) {
            BlockState existing = context.getWorld().getBlockState(context.getBlockPos());
            Direction existingFacing = existing.get(Properties.FACING);
            
            return newFacing != existingFacing;
        }
        
        return true;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos pos = ctx.getBlockPos();
        Direction direction = ctx.getSide();
        FluidState fluidState = ctx.getWorld().getFluidState(pos);
        BlockState existingState = ctx.getWorld().getBlockState(pos);
    
        if (existingState.getBlock() instanceof Panel) {
            // Update the appropriate direction property
            switch (direction) {
                case NORTH -> existingState = existingState.with(HAS_PANEL_NORTH, true);
                case SOUTH -> existingState = existingState.with(HAS_PANEL_SOUTH, true);
                case EAST -> existingState = existingState.with(HAS_PANEL_EAST, true);
                case WEST -> existingState = existingState.with(HAS_PANEL_WEST, true);
                case UP -> existingState = existingState.with(HAS_PANEL_UP, true);
                case DOWN -> existingState = existingState.with(HAS_PANEL_DOWN, true);
            }
            return existingState;
        }
    
        // For new placement, set the appropriate direction property
        BlockState newState = this.getDefaultState()
            .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER)
            .with(Properties.FACING, direction)
            .with(HAS_PANEL_NORTH, direction == Direction.NORTH)
            .with(HAS_PANEL_SOUTH, direction == Direction.SOUTH)
            .with(HAS_PANEL_EAST, direction == Direction.EAST)
            .with(HAS_PANEL_WEST, direction == Direction.WEST)
            .with(HAS_PANEL_UP, direction == Direction.UP)
            .with(HAS_PANEL_DOWN, direction == Direction.DOWN);
    
        return newState;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof PanelBlockEntity) {
                // Handle any cleanup if needed
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if (!world.isClient) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof PanelBlockEntity) {
                world.updateListeners(pos, state, state, Block.NOTIFY_ALL);
            }
        }
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCodec'");
    }
}