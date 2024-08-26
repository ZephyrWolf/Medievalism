    @Override
    protected void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston)
    {
        if (pState.getBlock() != pNewState.getBlock())
        {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof StoneBenchBlockEntity entity)
            {
                entity.dropInventory();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult)
    {
        if (!pLevel.isClientSide())
        {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof StoneBenchBlockEntity entity)
            {
                ((ServerPlayer) pPlayer).openMenu(entity, pPos);
            }
            else
            {
                throw new IllegalStateException("Menu provider is missing!");
            }
        }
        //return InteractionResult.SUCCESS_NO_ITEM_USED;
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }
