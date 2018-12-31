/*
package com.sample.blog;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.selection.SelectionTracker;
import io.reactivex.Notification;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

*/
/*
 * Created by akhil on 23/10/18.
 *//*


public class MainActivity extends AppCompatActivity implements PlainUserListAdapter.onClickUserItemClickListener {

    private RecyclerView recUsers;

    private UsersListAdapterWithSelectionTracker usersListAdapter;

    private PlainUserListAdapter plainUserListAdapter;

    private List<SampleUserDetailsPojo> usersList = new ArrayList<>();

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private SelectionTracker<Long> selectionTracker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        recUsers = findViewById(R.id.recUsers);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recUsers.setLayoutManager(layoutManager);

        getUserDetails();

    }

    private void listenToEvents() {
        plainUserListAdapter.getUsersDetailsObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(String username) {
                        Toast.makeText(MainActivity.this, username, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void getUserDetails() {
        Single<Response<List<SampleUserDetailsPojo>>> testObservable = TestApplication.getRestClient().getRestInterface().getUserDetails();

        testObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<List<SampleUserDetailsPojo>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(Response<List<SampleUserDetailsPojo>> listResponse) {
                        usersList = listResponse.body();
                        //usersListAdapter = new UsersListAdapterWithSelectionTracker(usersList,MainActivity.this);
                        plainUserListAdapter = new PlainUserListAdapter(usersList, MainActivity.this);
                        recUsers.setAdapter(plainUserListAdapter);

                        plainUserListAdapter.getUserDetailsPubSub()
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Observer<Notification<String>>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {
                                        compositeDisposable.add(d);
                                    }

                                    @Override
                                    public void onNext(Notification<String> stringNotification) {
                                        if (stringNotification.isOnNext())
                                            Toast.makeText(MainActivity.this, stringNotification.getValue(), Toast.LENGTH_SHORT).show();
                                        else if (stringNotification.isOnError())
                                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        e.printStackTrace();
                                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                });


                       */
/* selectionTracker = new SelectionTracker.Builder<>("my_selection",
                                recUsers,
                                new UsersListAdapterWithSelectionTracker.KeyProvider(recUsers.getAdapter()),
                                new UsersListAdapterWithSelectionTracker.DetailsLookup(recUsers),
                                StorageStrategy.createLongStorage())
                                .withSelectionPredicate(new UsersListAdapterWithSelectionTracker.Predicate())
                                .build();
                        usersListAdapter.setSelectionTracker(selectionTracker);*//*



                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }


    @Override
    public void onClickUserListItem(String username) {
        Toast.makeText(this, username, Toast.LENGTH_SHORT).show();
    }
}
*/
