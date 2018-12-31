/*
package com.sample.blog;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.subjects.PublishSubject;

*/
/*
 * Created by akhil on 8/11/18.
 *//*


public class PlainUserListAdapter extends RecyclerView.Adapter<PlainUserListAdapter.ViewHolder> {

    private List<SampleUserDetailsPojo> usersList;

    private onClickUserItemClickListener listener;

    private Observable<String> usersDetailsObservable;

    private PublishSubject<Notification<String>> userDetailsPubSub = PublishSubject.create();


    public PlainUserListAdapter(List<SampleUserDetailsPojo> usersList, onClickUserItemClickListener listener) {
        this.usersList = usersList;
        this.listener = listener;
    }

    public Observable<String> getUsersDetailsObservable() {
        usersDetailsObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {

            }
        });
        return usersDetailsObservable;
    }

    @NonNull
    @Override
    public PlainUserListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user, viewGroup, false);
        return new PlainUserListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlainUserListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.updateUi(i);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public PublishSubject<Notification<String>> getUserDetailsPubSub() {
        return userDetailsPubSub;
    }

    public interface onClickUserItemClickListener {
        void onClickUserListItem(String username);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvUserName, tvEmail, tvMobileNumber;
        private SampleUserDetailsPojo sampleUserDetailsPojo;
        private UsersListAdapterWithSelectionTracker.Details details;
        private CardView cvUser;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvMobileNumber = itemView.findViewById(R.id.tvMobileNumber);
            cvUser = itemView.findViewById(R.id.cvUser);
            details = new UsersListAdapterWithSelectionTracker.Details();
            itemView.setOnClickListener(this);
        }

        void updateUi(int position) {
            details.position = position;
            sampleUserDetailsPojo = usersList.get(position);
            tvUserName.setText(sampleUserDetailsPojo.getUsername());
            tvEmail.setText(sampleUserDetailsPojo.getEmail());
            tvMobileNumber.setText(sampleUserDetailsPojo.getPhone());
        }

        @Override
        public void onClick(View view) {
         */
/*   if (!TextUtils.isEmpty(sampleUserDetailsPojo.getUsername()))
            {
                userDetailsPubSub.onNext(Notification.createOnNext(sampleUserDetailsPojo.getUsername()));
            }
            else {
                userDetailsPubSub.onError(new Throwable("Value is Null",new NullPointerException()));
            }*//*

*/
/*
         try {
             userDetailsPubSub.onNext(Notification.createOnNext(sampleUserDetailsPojo.getUsername()));
         }catch (Exception e)
         {

         }*//*

            */
/*usersDetailsObservable = Observable.create(new ObservableOnSubscribe<String>() {
                @Override
                public void subscribe(ObservableEmitter<String> emitter) {
                    try {
                        emitter.onNext(sampleUserDetailsPojo.getName());
                    } catch (NullPointerException e) {
                        emitter.onError(e);
                    }
                }
            });*//*

            // listener.onClickUserListItem(sampleUserDetailsPojo.getUsername());
        }
    }
}
*/
