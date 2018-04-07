package com.teamtreehouse.smellslikebakin;

public class GridAdapter extends RecyclerAdapter {
    private final GridFragment.OnRecipeSelectedInterface mListener;

    public GridAdapter(GridFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onRecipeSelected(int adapterPosition) {
        mListener.onGridRecipeSelected(adapterPosition);

    }
}
