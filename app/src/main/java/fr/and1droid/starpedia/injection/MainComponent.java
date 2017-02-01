package fr.and1droid.starpedia.injection;

import javax.inject.Singleton;

import dagger.Component;
import fr.and1droid.starpedia.service.ServiceFactory;
import fr.and1droid.starpedia.ui.detail.DetailActivity;
import fr.and1droid.starpedia.ui.list.EntityRecyclerViewAdapter;
import fr.and1droid.starpedia.ui.list.ListActivity;

@Singleton
@Component(modules = ServiceModule.class)
public interface MainComponent {

    void inject(ListActivity target);

    void inject(ServiceFactory target);

    void inject(EntityRecyclerViewAdapter target);

    void inject(DetailActivity target);
}
