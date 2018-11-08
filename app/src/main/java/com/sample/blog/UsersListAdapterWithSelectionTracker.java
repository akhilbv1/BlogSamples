package com.sample.blog;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.selection.ItemKeyProvider;
import androidx.recyclerview.selection.SelectionTracker;

/*
 * Created by akhil on 25/10/18.
 */

public class UsersListAdapterWithSelectionTracker extends RecyclerView.Adapter<UsersListAdapterWithSelectionTracker.ViewHolder> {

    private List<SampleUserDetailsPojo> usersList;

    private SelectionTracker<Long> selectionTracker;

    private onClickUserItemClickListener listener;

    public UsersListAdapterWithSelectionTracker(List<SampleUserDetailsPojo> usersList, onClickUserItemClickListener listener) {
        this.usersList = usersList;
        this.listener = listener;
    }


    public void setSelectionTracker(
            SelectionTracker<Long> selectionTracker) {
        this.selectionTracker = selectionTracker;
    }


    public interface onClickUserItemClickListener{
        void onClickUserListItem(String username);
    }


    @NonNull
    @Override
    public UsersListAdapterWithSelectionTracker.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersListAdapterWithSelectionTracker.ViewHolder viewHolder, int i) {
        viewHolder.updateUi(i);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    static class Details extends ItemDetailsLookup.ItemDetails<Long> {

        long position;

        Details() {
        }

        @Override
        public int getPosition() {
            return (int) position;
        }

        @Nullable
        @Override
        public Long getSelectionKey() {
            return position;
        }

        @Override
        public boolean inSelectionHotspot(@NonNull MotionEvent e) {
            return true;
        }
    }

    static class KeyProvider extends ItemKeyProvider<Long> {

        KeyProvider(RecyclerView.Adapter adapter) {
            super(ItemKeyProvider.SCOPE_MAPPED);
        }

        @Nullable
        @Override
        public Long getKey(int position) {
            return (long) position;
        }

        @Override
        public int getPosition(@NonNull Long key) {
            long value = key;
            return (int) value;
        }
    }

    static class DetailsLookup extends ItemDetailsLookup<Long> {

        private RecyclerView recyclerView;

        DetailsLookup(RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
        }

        @Nullable
        @Override
        public ItemDetails<Long> getItemDetails(@NonNull MotionEvent e) {
            View view = recyclerView.findChildViewUnder(e.getX(), e.getY());
            if (view != null) {
                RecyclerView.ViewHolder viewHolder = recyclerView.getChildViewHolder(view);
                if (viewHolder instanceof ViewHolder) {
                    return ((ViewHolder) viewHolder).getItemDetails();
                }
            }
            return null;
        }
    }

    static class Predicate extends SelectionTracker.SelectionPredicate<Long> {

        @Override
        public boolean canSetStateForKey(@NonNull Long key, boolean nextState) {
            return true;
        }

        @Override
        public boolean canSetStateAtPosition(int position, boolean nextState) {
            return true;
        }

        @Override
        public boolean canSelectMultiple() {
            return true;
        }
    }

     class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvUserName, tvEmail, tvMobileNumber;
        private SampleUserDetailsPojo sampleUserDetailsPojo;
        private Details details;
        private CardView cvUser;

         ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvMobileNumber = itemView.findViewById(R.id.tvMobileNumber);
            cvUser = itemView.findViewById(R.id.cvUser);
            details = new Details();
            itemView.setOnClickListener(this);
        }

         void updateUi(int position) {
            details.position = position;
            sampleUserDetailsPojo = usersList.get(position);
            tvUserName.setText(sampleUserDetailsPojo.getUsername());
            tvEmail.setText(sampleUserDetailsPojo.getEmail());
            tvMobileNumber.setText(sampleUserDetailsPojo.getPhone());

            if (selectionTracker != null) {
                if (UsersListAdapterWithSelectionTracker.this.selectionTracker.isSelected(details.getSelectionKey())) {
                    cvUser.setCardBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorAccent));
                } else {
                    cvUser.setCardBackgroundColor(itemView.getContext().getResources().getColor(R.color.white));
                }
            }
        }

        Details getItemDetails(){
            return details;
        }

         @Override
         public void onClick(View view) {
             listener.onClickUserListItem(sampleUserDetailsPojo.getUsername());
         }
     }
}
