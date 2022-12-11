package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class MoveTaskTouchHelperCallback extends ItemTouchHelper.Callback {

    private final ItemTouchHelperContract adapter;
    public MoveTaskTouchHelperCallback(ItemTouchHelperContract adapter) {
        this.adapter = adapter;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        return makeMovementFlags(dragFlags, 0);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        adapter.onRowMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder,
                                  int actionState) {


        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            if (viewHolder instanceof TaskLayoutRecyclerViewAdapter.MyViewHolder) {
                TaskLayoutRecyclerViewAdapter.MyViewHolder myViewHolder=
                        (TaskLayoutRecyclerViewAdapter.MyViewHolder) viewHolder;
                adapter.onRowSelected(myViewHolder);
            }

        }

        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override
    public void clearView(RecyclerView recyclerView,
                          RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);

        if (viewHolder instanceof TaskLayoutRecyclerViewAdapter.MyViewHolder) {
            TaskLayoutRecyclerViewAdapter.MyViewHolder myViewHolder=
                    (TaskLayoutRecyclerViewAdapter.MyViewHolder) viewHolder;
            adapter.onRowClear(myViewHolder);
        }
    }

    public interface ItemTouchHelperContract {

        void onRowMoved(int fromPosition, int toPosition);
        void onRowSelected(TaskLayoutRecyclerViewAdapter.MyViewHolder myViewHolder);
        void onRowClear(TaskLayoutRecyclerViewAdapter.MyViewHolder myViewHolder);

    }

}
